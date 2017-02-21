#Material Design
Material Design es una guía de diseño visual, de movimientos y de interacción en distintas plataformas y dispositivos. En Android, se proporcionan los siguientes elementos que te permitirán crear aplicaciones en Material Design:

 - Un tema nuevo.
 - Widgets nuevos para vistas mas complejas.
 - Nuevas APIs para sombras y animaciones personalizadas.

##Tema Material
Este tema ofrece un nuevo estilo para tu aplicación, widgets del sistema que te permiten configurar la paleta de colores y animaciones predeterminadas para información táctil y transiciones de actividades.

![Material Dark](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson7/images/MaterialDark.png)
Material Dark


![MaterialLight](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson7/images/MaterialLight.png)
Material Light

Este tema solo esta disponible en Android 5.0 (API 21) y superior. Para poder usar este tema con versiones anteriores es necesario trabajar con las librerías de soporte v7

###Como personalizar la paleta de colores?
Si se desea personalizar la paleta de colores del tema es necesario modificar los valores de los siguientes estilos:

```xml
<resources>
  <!-- Hereda de material theme -->
  <style name="AppTheme" parent="android:Theme.Material">
    <!-- Color principal del tema -->
    <item name="android:colorPrimary">@color/primary</item>
    <!--   Variante oscura para el colo del status bar-->
    <item name="android:colorPrimaryDark">@color/primary_dark</item>
    <!--   Color para los controles UI como por ejemplo checkboxes y campos de texto -->
    <item name="android:colorAccent">@color/accent</item>
  </style>
</resources>
```

![ThemeColors](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson7/images/ThemeColors.png)

##Widgets nuevos
Android brinda dos widgets nuevos para mostrar listas, grillas y tarjetas con estilo y animaciones de Material Design: `RecyclerView` y `CardView`

![RecyclerView](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson7/images/list_mail.png)
Recycler View

![CardView](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/Lesson7/images/card_travel.png)
CardView

##Elevación de vistas
Las vistas pueden proyectar sombras y el valor de elevación de una vista determina el tamaño de su sombra y el orden en que será dibujada. Para establecer la elevación de una vista, usa el atributo android:elevation en tus diseños:

```xml
<TextView
    android:id="@+id/my_textview"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="@string/next"
    android:background="@color/white"
    android:elevation="5dp" />
```




##Animaciones
La nueva API de animaciones permite crear animaciones personalizadas para la información táctil de los controles de UI. Además realizo cambios en el estado de las vistas y transiciones entre actividades. Esta API permite hacer lo siguiente:

 - Responder a los eventos tactiles de las vistas mediante animaciones de información táctil.
 - Mostrar y ocultar vistas con efecto circular.
 - Transiciones de actividades.
 - Crear animaciones con movimiento curvo.
 - Animar cambios en una o más propiedades de las vistas.

###Personalizar la respuesta táctil
La respuesta táctil brinda una confirmación visual instantánea en el punto de contacto cuando los usuarios interactúan con los elementos de la UI. Las animaciones predeterminadas de la respuesta táctil para botones usan la nueva clase RippleDrawable, que realiza una transición entre diferentes estados con un efecto de ondas.

En la mayoría de los casos, debes aplicar esta funcionalidad en la vista XML especificando el fondo de la vista como:

 1. ?android:attr/selectableItemBackground para un efecto de ondas con límites.
 2. ?android:attr/selectableItemBackgroundBorderless para un efecto de ondas que se extiende más allá de la vista. Se lo dibujará en la vista primaria más cercana de la vista (que lo limitará) con un fondo de valor no nulo.

```xml
<Button
        android:id="@+id/button"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerHorizontal="true"
        android:layout_marginTop="10dp"
        android:background="?android:attr/selectableItemBackgroundBorderless"
        android:text="Clickeame!" />
```




##Referencias:

 - https://developer.android.com/design/material/index.html?hl=es
 - https://developer.android.com/training/material/compatibility.html?hl=es
 - https://developer.android.com/training/material/index.html?hl=es
 - https://developer.android.com/training/material/drawables.html?hl=es
