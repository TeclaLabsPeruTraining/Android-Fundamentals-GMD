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

Este tema solo esta disponible en Android 5.0 y superior. Para poder usar este tema con versiones anteriores es necesario trabajar con las librerias de soporte v7

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

##Animaciones
La nueva API de animaciones permite crear animaciones personalizadas para la información táctil de los controles de UI. Además realizo cambios en el estado de las vistas y transiciones entre actividades. Esta API permite hacer lo siguiente:

 - Responder a los eventos tactiles de las vistas mediante animaciones de información táctil.
 - Mostrar y ocultar vistas con efecto circular.
 - Transiciones de actividades.
 - Crear animaciones con movimiento curvo.
 - Animar cambios en una o más propiedades de las vistas.


##Referencias:

 - https://developer.android.com/design/material/index.html?hl=es
 - https://developer.android.com/training/material/compatibility.html?hl=es
 - 
