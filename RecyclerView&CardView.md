# Android-Fundamentals-GMD
Android Fundamentals (23h)

## Recycler View

Para crear listas y tarjetas con estilo Material Design puedes usar *widgets* `RecyclerView` y `CardView`.

###Listas con Recycler View
`RecyclerView` es una versión mas flexible y avanzada de `ListView`. Simplifica la pantalla y la manipulación de grandes conjuntos de datos al proporcionar lo siguiente:

 - Administradores de diseño para el posicionamiento de los elementos.
 - Animaciones predeterminadas para acciones comunes como por ejemplo quitar o agregar algún elemento.

![RecyclerView](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson4/images/RecyclerView.png)

Para usar un `RecyclerView` es necesario especificarle un adaptador y, a diferencia de un `ListView`, un administrador de diseño.

Un administrador de diseño es el encargado de posicionar las vistas de los elementos dentro del RecyclerView y determinar cuando volver a usar estas vistas.

`RecyclerView` proporciona estos tipos de administradores de diseño:

 - `LinearLayoutManager` muestra elementos en una lista vertical u horizontal.
 - `GridLayoutManager` muestra elementos en una tabla.
 - `StaggeredGridLayoutManager` muestra elementos en una tabla escalonada.

Para crear un administrador de diseño personalizado se debe crear una clase que extienda de `RecyclerView.LayoutManager`.


####Animaciones

Las animaciones para agregar o eliminar elementos están disponibles de manera predeterminada en `RecyclerView`. Para customizarlas es necesario crear una clase que extienda de `RecyclerView.ItemAnimator` y usar el método  `RecyclerView.setItemAnimator()`. 

####Ejemplo de implementacion RecyclerView

Primero incluimos el tag de RecyclerView en nuestro layout:
```xml
<android.support.v7.widget.RecyclerView
    android:id="@+id/myRecyclerView"
    android:scrollbars="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
```

Luego obtenemos su referencia y le asignamos un adapter y un administrador de diseño:

```java
public class MyActivity extends Activity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.myRecyclerView);

        // Utiliza esta opción para mejorar el performance 
        //si es que se sabe que el contenido no va a cambiar el 
        // alto del RecyclerView.
        mRecyclerView.setHasFixedSize(true);

        // usamos un linear Layout Manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // especificamos el adapter
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
    ...
}
```

####Ejemplo implementación de un Adapter para RecyclerView

Para crear un adapter personalizado es necesario crear una clase que extienda de `RecyclerView.Adapter` 
```java
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] mDataset;

    // Constructor del adapter
    public MyAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Devuelve el tamaño de la data
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    // Se crean nuevas vistas (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                               .inflate(R.layout.my_text_view, parent, false);
        
        ...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Reemplazar el contenido de una vista
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - Obtener un elemento del set de data
        // - reemplazar el contenido de la vista con la data obtenida
        holder.mTextView.setText(mDataset[position]);

    }

    // Provee una referencia a las vistas para cada item
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Cada item de la data es solo un string en este caso
        public TextView mTextView;
        public ViewHolder(TextView v) {
            super(v);
            mTextView = v;
        }
    }
}

```


###CardViews
`CardView` extiende de `FrameLayout`. Permite mostrar información dentro de tarjetas que son uniformes a nivel de plataforma. Los `CardView`s pueden tener sombras y bordes redondeados.

Código de ejemplo para incluir un `CardView` en el layout
```xml
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    xmlns:card_view="http://schemas.android.com/apk/res-auto"
    ... >
    
    <android.support.v7.widget.CardView
        xmlns:card_view="http://schemas.android.com/apk/res-auto"
        android:id="@+id/cardView"
        android:layout_gravity="center"
        android:layout_width="200dp"
        android:layout_height="200dp"
        card_view:cardCornerRadius="4dp">

        <TextView
            android:id="@+id/infoText"
            android:layout_width="match_parent"
            android:layout_height="match_parent" />
    </android.support.v7.widget.CardView>
</LinearLayout>
```

Los widgets `RecyclerView` y `CardView` son parte de las Bibliotecas de soporte v7. Para usar estos widgets en tu proyecto, agrega estas Dependencias de Gradle al módulo de tu aplicación:

```groovy
dependencies {
    ...
    compile 'com.android.support:cardview-v7:21.0.+'
    compile 'com.android.support:recyclerview-v7:21.0.+'
}
```

###Referencias

 - https://developer.android.com/training/material/lists-cards.html?hl=es
 - https://developer.android.com/training/material/compatibility.html?hl=es