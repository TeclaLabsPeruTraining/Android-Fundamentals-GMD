
## Controles de Seleccion - Eventos de Usuario 
Eventos centrados en el objeto `View`  

### View Events
Todo `View`, ya sea `Button`, `ImageView`, `TextView`, etc, posee varios *event listeners* que pueden ser usados gracias al patrón `setOnEvent` el cual implica pasar una clase que implemente una interface de un evento en particular. Los listeners disponibles para cualquier `View` son los siguientes:

 * `setOnClickListener` - Callback cuando la vista es clickeada.
 * `setOnDragListener` - Callback cuando la vista es arrastrada.
 * `setOnFocusChangeListener` - Callback cuando la vista cambia su foco.
 * `setOnGenericMotionListener` - Callback para gestos arbitrarios.
 * `setOnKeyListener` - Callback cuando se presiona una tecla cuando la vista tiene el foco.
 * `setOnLongClickListener` - Callback cuando la presión de la vista es mantenida.
 * `setOnTouchListener` - Callback cuando la vista es tocada.

###Como implementar estos listeners?

A través del código Java, la forma es muy similar para todos los eventos. Tomaremos como ejemplo el `OnClickListenner`. 
Se necesita una referencia a la vista y luego se usa el método `set` asociado al evento para pasarle la clase que implemente la interfaz relacionada al evento.  
Por ejemplo:

```java
Button button = (Button) findViewById(R.id.button);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        // Haz algo aquí	
    }
});
```

De esta manera se puede implementar cualquier otro evento relacionado al objeto `View`.

**Se puede usar XML?**

Sí, pero **solo** para el evento `onClick`. Este evento permite usar un *atajo* desde el xml que permitirá definir la función que se ejecutará cuando suceda el evento.
Ejemplo:

```xml
<Button 
    android:id="@+id/button"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/login_button"
    android:onClick="login" />
```

Dentro del activity/fragmento que muestra este layout el siguiente método debe ser implementado:

```java
/** Esta función es llamada cuando el usuario hace click en el botón */
public void login(View view) {
    // Haz algo en respuesta al evento
}
```

### EditText Listeners

Además de los *listeners* ya descritos existen alguno que son comunes para los campos de entrada. 

 * `addTextChangedListener` - Se dispara cada vez que el texto en el campo ha sido cambiado.
 * `setOnEditorActionListener` - Se dispara cada vez que el "action button" del teclado es presionado.

#### TextChangedListener

De esta manera se implementa un TextChangedListener:

```java
EditText editText = (EditText) findViewById(R.id.editText);
editText.addTextChangedListener(new TextWatcher() {
	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		// Se ejecuta apenas el texto ha cambiado
	}
	
	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {
		// Se ejecuta justo antes que el texto cambie
	}
	
	@Override
	public void afterTextChanged(Editable s) {
		// Se ejecuta justo despues de que el texto ha cambiado.
		textView.setText(s.toString());
	}
});
```


#### OnEditorActionListener

Para implementar este listener primero necesitamos especificar un *action button* a nuestro campo. Esto lo podemos hacer desde el XML.
En este ejemplo especificaremos el botón de "done" para nuestro campo. El parámetro `android:singleLine="true"` es necesario en este caso.

```xml
<EditText
   android:id="@+id/editText"
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"
   android:inputType="text"
   android:singleLine="true"
   android:imeOptions="actionDone">
   <requestFocus />
</EditText>
```

Ahora, implementamos el listener en el código Java de la siguiente manera:

```java
editText.setOnEditorActionListener(new OnEditorActionListener() {
	@Override
	public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
		if (actionId == EditorInfo.IME_ACTION_DONE) {
                        String texto = v.getText().toString();
			Toast.makeText(MainActivity.this, texto, Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
});
```

### Otros *listeners* para campos de entrada

Asi com los `EditText`, existen otras vistas que incluyen sus propios *listeners* como por ejemplo `NumberPicker` o `SeekBar`.
Haremos un ejemplo del `NumberPicker`.

```java
NumberPicker numberPicker = (NumberPicker) findViewById(R.id.numberPicker);
numberPicker.setOnValueChangedListener(new OnValueChangeListener() {
	@Override
	public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
		// Lógica aquí
	}
});
```

###**Ejercicio:** 
Implementar una pantalla de login en donde se tenga las siguientes consideraciones:

 1. Edit Text Usuario: El campo usuario debe tener formato de email.
 2. Edit Text Password: El campo password debe tener al menos 1 mayúscula, 1 minúscula, 1 número y un caracter especial.
 3. El campo password debe tener un *action button* "done" el cual una vez apretado tenga la misma función que el botón de login.
 4. Validar que ninguno sea nulo o vacío.
 5. Button Login, el botón login debe realizar una navegación hacia una nueva pantalla si es que ha cumplido con las condiciones anteriores.

Tip: Usar regex para validar los campos.

Imagen referencial: 
![imagen ejercicio](https://github.com/BelatrixTraining/Android-Fundamentals/blob/Lesson4-2/images/ejercicio.jpg)

TIP: Reg-Ex para validar el password con las condiciones dadas
	"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}"
Para el caso del mail podemos utilizar
	android.util.Patterns.EMAIL_ADDRESS
## Referencias

 * <http://developer.android.com/reference/android/widget/Button.html>
 * <http://developer.android.com/reference/android/view/View.html#setOnClickListener>
 * <http://developer.android.com/guide/topics/ui/controls/button.html>
 * <http://developer.android.com/guide/topics/ui/ui-events.html>


