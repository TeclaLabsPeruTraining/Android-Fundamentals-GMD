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
Por defecto Android Studio muestra los archivos del proyecto en la vista **Android** (ver imagen). Esta vista **no** muestra la jerarquia real de los archivos en el disco, sin embargo agrupa los archivos para una mejor navegación entre ellos 
![Project View](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/lesson1/images/projectview-p2.png)

Tener en cuenta que  la vista por defecto Android:

 - Muestra todos los archivos relacionados con la compilación del proyecto en un grupo llamado **Gradle Scripts**.
 - Muestra todos los archivos manifest para cada módulo en un grupo de nivel de módulo.
 - Muestra todos los archivos de recursos alternativos en un único grupo en lugar de carpetas separadas por calificadores.

## Composición de un proyecto (Carpetas, paquetes, librerías, tipos de archivos, etc).

## Gradle

##Referencias

 - https://developer.android.com/studio/projects/index.html?hl=es-419
 - https://developer.android.com/studio/intro/index.html?hl=es-419