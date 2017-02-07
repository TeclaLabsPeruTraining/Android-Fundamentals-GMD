# Android Fundamentals (23h)

## Android Studio
Android Studio es el entorno oficial para desarrollo de aplicaciones en Android. Está basado en el IDE IntelliJ IDEA.
Además de todas las herramientas que posee IntelliJ, Android Studio ofrece las siguientes funcionalidades para elevar la productibilidad al momento de desarrollar apps:

 - Un sistema de compilación configurable basado en Gradle.
 - Un emulador de carga rápida.
 - Hace posible que se pueda desarrollar para todos los dispositivos Android en un mismo entorno.
 - *Instant Run*, hace que se apliquen los cambios en el app sin necesidad de generar un nuevo APK.
 - Plantillas de código en Github con ejemplos comunes.
 - Diversas herramientas y frameworks para pruebas.
 - Integración con **Lint** para detectar problemas de rendimiento, uso, version, etc.
 - Compatibilidad con NDK y C++.
 - Soporte para Google Cloud Platform.

###Estructura del Proyecto
Todo proyecto tiene 1 o más módulos con archivos de código de código fuente o archivos de recurso. Un módulo puede usar a otro como dependencia. Existen 3 tipos distintos de módulos:

 - **Módulo de App para Android:**
Funciona como contenedor para el código fuente, archivos de recursos y demás archivos de configuración como el build.gradle o el manifest.
 - **Módulo de Biblioteca:**
Funciona como contenedor para código reutilizable y puede ser usado como una dependencia en otros módulos. Un módulo de biblioteca, estructuralmente, es igual a un módulo de app pero cuando se compila se genera un archivo de código (**AAR** en caso de ser módulo de biblioteca Android o **JAR** en caso de ser módulo de biblioteca Java) en lugar de un APK y no se puede instalar en un dispositivo.
 - **Módulo de Google Cloud:**
 Funciona como contenedor para código de backend de Google Cloud.


###Archivos de proyecto
Por defecto Android Studio muestra los archivos del proyecto en la vista **Android** (ver imagen). Esta vista **no** muestra la jerarquia real de los archivos en el disco, sin embargo agrupa los archivos para una mejor navegación entre ellos.

![Project View](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/lesson1/images/projectview-p2.png)


Tener en cuenta que  la vista por defecto Android:

 - Muestra todos los archivos relacionados con la compilación del proyecto en un grupo llamado **Gradle Scripts**.
 - Muestra todos los archivos manifest para cada módulo en un grupo de nivel de módulo.
 - Muestra todos los archivos de recursos alternativos en un único grupo en lugar de carpetas separadas por calificadores.

###Interfaz de Usuario
La interfaz de Android Studio cuenta con varias áreas lógicas las cuales podemos observar en la siguiente imagen.

![Main Window](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/lesson1/images/main-window.png)

 1. Barra de herramientas.
 2. Barra de navegación.
 3. Ventana del editor.
 4. Ventanas de herramientas.
 5. Barra de estado.

####Shortcuts para herramientas
Estos son los atajos de teclado para las herramientas más comunes	
![shortcuts](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/lesson1/images/toolsKeywords.png)

##Gradle
Gradle compila el código fuente y recursos de la aplicación y genera un APK, el cual puedes probar, implementar, firmar y distribuir.
Android Studio utiliza Gradle como base del sistema de compilación y proporciona más características propias de Android a través del Android Plugin para Gradle.
Gradle permite hacer lo siguiente:

 - Personalizar, configurar y extender el proceso de compilación.
 - Crear varios APKs para una misma aplicación con funciones diferentes usando el mismo proyecto y los mismos módulos.

Los archivos *build.gradle* son los denominados archivos de compilación de Android Studio. Estos son archivos de texto que usan una sintaxis Groovy para configurar la compilación. Cada proyecto tiene un archivo de compilación de nivel superior para todo el proyecto y archivos de compilación de nivel de módulo independiente para cada módulo.  

###Configuración de la compilación
Gradle permite automatizar y administrar el proceso de compilación y al mismo tiempo definir configuraciones de compilación personalizadas y flexibles. Cada una de estas define un código y recursos propios y reutilizar todas las partes comunes a todas las versiones del app. 
Es posible utilizar Gradle y el plugin de Android para Gradle de manera indendiente a Android Studio y el resultado de la compilación es el mismo que si es utilizara desde el mismo Android Studio.

####Proceso de compilación
La siguiente imagen nos ilustra de manera sencilla el proceso de compilación.

![build process](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/lesson1/images/build-process.png)

El proceso de compilación para un módulo tiene las siguientes fases:

 1. Los compiladores convierten el código fuente en archivos DEX.
 2. El empaquetador de APK combina los archivos DEX y los recursos compilados en un APK.
 3. El empaquetador de APK firma el APK usando el keyStore de debug o release según sea el caso.
 4. Antes de generar el APK final el empaquetador usa la herramienta zipAlign para optimizar el uso de memoria de la aplicación.

###Configuraciones de compilación personalizadas
Gradle y el plugin de Android para Gradle permiten configurar los siguientes aspectos de la configuración:

 - **Tipos de compilación:**
 Los tipos de compilación definen propiedades que Gradle utiliza al momento de compilar y empaquetar la aplicación. Por defecto, Android Studio define dos tipos: Debug y Release.
 - **Tipos de producto:**
 - **Variantes de compilación:**
 - **Entradas del Manifiesto:**
 - **Dependencias:**
 - **Firma:**
 - **Proguard:**
 - **Divisiones de APK:**

###Archivo de configuracion de Gradle

###Archivo de configuración de nivel superior

###Archivo de configuración de nivel de módulo

###Archivo de propiedades de Gradle



##Referencias

 - https://developer.android.com/studio/projects/index.html?hl=es-419
 - https://developer.android.com/studio/intro/index.html?hl=es-419
 - https://developer.android.com/studio/build/index.html?hl=es-419#build-process