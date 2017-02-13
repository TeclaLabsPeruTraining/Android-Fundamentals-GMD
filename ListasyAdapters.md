 
##Basic Adapters
    
 Cuando queremos mostrar una lista en Android solemos usar el componente `ListView`*. Ademas de este componente es necesario usar un `Adapter` para que sirva de intermediario entre nuestra fuente de datos y nuestro `AdapterView` que en este caso seria nuestra `ListView`. En el siguiente grafico podemos observar como es el flujo entre estos componentes.
 ![DataSource-Adapter-List Flow](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson4/images/Adapter1.jpg)

Como se ve en la imagen, el adapter se encuentra en medio de la fuente de datos (un `List` o `Cursor`) y nuestra ListView (o algun otro AdapterView) y se encarga de manejar el array que tendra la data a mostrar y convertir cada item de este array en su correspondiente View.

*Actualmente se suele usar RecyclerView en lugar de ListView. Este tema lo tocaremos en clases posteriores.

###Manejo de las vistas

Cuando tenemos una `ListView` conectada a un `Adapter`, el adapter instanciará filas hasta que la `ListView` haya sido llenada con suficientes items para llenar el alto de la lista. Luego de eso no se creará más items en memoria.
Cuando el usuario haga scroll en la lista, los items que dejen la pantalla serán guardados en memoria para su uso mas adelante y cada fila nueva que aparezca en la pantalla reutilizará una vieja que ha sido guardada en memoria.
En el siguiente gráfico se puede visualizar como es el flujo de manejo de las vistas.
![Adapter View Management](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson4/images/adapterViewManagement.png)

###Tipos de Adapters
El SDK de android nos provee de distintos tipos de adapters

 - **BaseAdapter**: Es una clase abstracta de la cual derivan los demás Adapters de esta lista. Es posible hacer un adapter personalizado que herede de ella. Nos permite crear Adapters que se adapten mas a nuestras necesidades.
 - **ArrayAdapter**: Es una implementación del `BaseAdapter`. Es bastante útil cuando nuestra fuente de datos venga en forma de array.
 - **SimpleAdapter**: Otra implementación del `BaseAdapter`. En este caso nos ayuda a manejar data estática.
 - **CursorAdapter**: Adapter que implementa BaseAdapter y muestra data de un `Cursor` en una `ListView`.

###Como usar un ArrayAdapter
Es el mas sencillo de usar. En este ejemplo vemos como se instancia un ArrayAdapter. El constructor acepta 3 parametros: El contexto, el layout del item y la lista de items. Luego vemos como se conecta la `ListView` con el `ArrayAdapter`
```java
ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);

ListView listView = (ListView) findViewById(R.id.listView);
listView.setAdapter(arrayAdapter);
```

###Como usar un CursorAdapter
En este caso necesitaremos crear una clase que extienda de `CursorAdapter` y que sobreescriba los métodos `newView` y `bindView`. El primero es usado para *inflar* una nueva vista. El segundo, para *bindear* la data con la vista dada.
Veamos un ejemplo

####XML del item
En este xml definimos la vista que tendrá cada item del cursor
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
 android:layout_width="match_parent"
 android:layout_height="match_parent" >
    <TextView
      android:id="@+id/nombre"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content" />
   <TextView
      android:id="@+id/apellido"
      android:layout_width="wrap_content"
      android:layout_height="wrap_content"/>
</LinearLayout>
```

####Definiendo el adapter
```java
public class UsuarioAdapter extends CursorAdapter {
  public UsuarioAdapter(Context context, Cursor cursor) {
      super(context, cursor, 0);
  }

  @Override
  public View newView(Context context, Cursor cursor, ViewGroup parent) {
      return LayoutInflater.from(context).inflate(R.layout.item_usuario, parent, false);
  }
  
  @Override
  public void bindView(View view, Context context, Cursor cursor) {
      TextView nombreView = (TextView) view.findViewById(R.id.nombre);
      TextView apellidoView = (TextView) view.findViewById(R.id.apellido);
      
      String nombre = cursor.getString(cursor.getColumnIndexOrThrow("nombre"));
      String apellido = cursor.getString(cursor.getColumnIndexOrThrow("apellido"));
      nombreView.setText(nombre);
      apellidoView.setText(apellido);
  }
}
```

####Relacionamos el adapter con la lista
```java
ListView listView = (ListView) findViewById(R.id.listView);
UsuarioAdapter usuarioAdapter = new UsuarioAdapter(this, usuarioCursor);
listView.setAdapter(usuarioAdapter);
```

###Implementando un BaseAdapter
`BaseAdapter` es un clase abstracta la cual podemos implementar y crear adapters mucho más flexibles y que se adapten mejor a nuestras necesidades. 
Cuando hacemos la implementación de un `BaseAdapter` debemos sobreescribir 4 métodos de manera obligatoria:

 - getCount: Método en el que indicamos cuantos items serán representados mediante este adapter.
 - getItem: Método que devuelve el item asociado a la posición especificada.
 - getItemId: Devuelve el id del item asociado a la posición especificada.
 - getView: Devuelve una vista que hará visible la data relacionada a la posición especificada. 

Aquí veremos un ejemplo de una implementación

```java
public class BaseAdapterExample extends BaseAdapter {

    private final List<String> mItems;
    private final LayoutInflater mInflater;
    private final Drawable starOn;

    public BaseAdapterExample(Context context, List<String> items) {
        mItems = items;
        mInflater = LayoutInflater.from(context);
        starOn = context.getResources().getDrawable(android.R.drawable.star_big_on);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(R.layout.item_adapter, null);
        TextView titleView = (TextView) convertView.findViewById(R.id.text);
        titleView.setText(mItems.get(position));
        final ImageView imageView = (ImageView) convertView.findViewById(R.id.itemImage);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setImageDrawable(starOn);
            }
        });
        return convertView;
    }
}

```

###Patrón View Holder
Con el fin de mejorar el performance de nuestra `ListView` debemos modificar la implementación del método `getView` y añadirle el patrón View Holder el cual acelera considerablemente la creación de las vistas evitando el uso desmedido del método `findByView`. 

####Definimos nuestro ViewHolder
```java
static class ViewHolder {
    TextView textView;
	ImageView imageView;
}
```

####Modificamos nuestra implementación del `getView`
```java
@Override
public View getView(int position, View convertView, ViewGroup parent) {
	ViewHolder viewHolder;
    if (convertView == null) {
	    convertView = mInflater.inflate(R.layout.item_adapter, null);
        viewHolder = new ViewHolder();
        viewHolder.textView = (TextView) convertView.findViewById(R.id.text);
		viewHolder.imageView = (ImageView) convertView.findViewById(R.id.itemImage);
        convertView.setTag(viewHolder);
	} else {
	    viewHolder = (ViewHolder) convertView.getTag();
    }
    viewHolder.textView.setText(mItems.get(position));
    .
    .
    .
    .
    return convertView;
}
```

##Referencias

 - http://android.amberfog.com/?p=296
 - https://developer.android.com/studio/profile/dev-options-rendering.html
 - https://www.youtube.com/watch?v=2lcoB5-PCCw
 - https://github.com/codepath/android_guides/wiki/Using-an-ArrayAdapter-with-ListView
 - http://www.gustekdev.com/2013/05/custom-cursoradapter-and-why-not-use.html
