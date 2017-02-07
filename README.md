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
 Estos representan las diferentes versiones de la aplicación que pueden ser publicadas para los usuarios como por ejemplo una versión demo y full o versión gratis y paga. Los tipos de producto son opcionales y deben ser creados manualmente.
 
 - **Variantes de compilación:** 
 Una variante de compilación es la unión de un tipo de compilación y un tipo de producto, y será la configuración que Gradle usará para compilar la aplicación. Las variantes de compilación se crean dinámicamente conforme se vayan creando tipos de compilación y tipos de producto.
 - **Entradas del Manifiesto:**
 Se puede especificar valores para algunas propiedades del manifest en la configuración de la variante de compilación y estos sobreescribiran los existentes en el manifest. Esto puede ser útil cuando se desea generar distintos APKs con nombres diferentes, minimo SDK o versión SDK de destino.
 - **Dependencias:**
 Gradle es capaz de administrar las dependencias del proyecto desde un repositorio local o remoto.
 - **Firma:**
 Gradle permite especificar configuraciones de firmas en la configuración de la compilación y puede firmar el APK automáticamente
 - **Proguard:** Gradle permite crear un archivo de configuración para proguard diferente para cada variante de compilación.

###Archivos de configuración de la compilación
Para crear configuraciones de compilación personalizadas se debe realizar cambios en uno o mas archivos de configuración de compilación y en los build.gradle.
Al iniciar un nuevo proyecto, Android Studio crear de manera automática algunos de esos archivos como se muestra en la siguiente imagen.
![Project Structure](https://github.com/TeclaLabsPeruTraining/Android-Fundamentals-GMD/blob/lesson1/images/project-structure.png)

Hay algunos archivos de configuración de compilación que forman parte de la estructura estándar de un proyecto. A continuación veremos el alcance y objetivo de cada uno de ellos:

####Archivo de configuración de Gradle
Es el archivo **settings.gradle**, está ubicado en la raíz del proyecto e indica a Gradle los módulos que debe incluir al momento de compilar el proyecto.

    include ‘:app’

 
####Archivo de configuración de nivel superior
Es el archivo **build.gradle** y está ubicado en la raíz del proyecto. En el se definen las configuraciones de compilación que se aplican a todos los módulos de proyecto.

```java
/**
 * El bloque buildscript{} es donde se configura los repositorios y 
 * dependencias para el mismo Gradle. No se debería incluir las 
 * dependencias para los módulos aquí.
 * Por ejemplo, en este bloque se incluye la dependencia del 
 * plugin de Android para Gradle ya que este provee instrucciones 
 * adicionales que Gradle necesita para compilar los módulos Android.
 */

buildscript {

    /**
     * El bloque repositories {} es donde se configuran los repositorios 
     * en donde Gradle busca o descarga las dependencias.
     * El siguiente código define JCenter como el repositorio en donde 
     * Gradle deberá buscar ss dependencias.
     */

    repositories {
        jcenter()
    }

    /**
     * El bloque dependencies {} block configura las dependencias que 
     * Gradle necesita para compilar el proyecto. La siguiente linea 
     * agrega el plugin de Android para Gradle versión 2.2.0 como una 
     * dependencia
     */

    dependencies {
        classpath 'com.android.tools.build:gradle:2.2.0'
    }
}

/**
 * El bloque allprojects {} es donde se configuran los repositorios y 
 * dependencias usados por todos los modulos en el proyecto, tales como 
 * `third-party`, plugins o  librerias. 
 * Dependencias que no son necesarias por todos los módulos del proyecto 
 * deben ser configuradas el los build.gradle a nivel de módulo.
 */

allprojects {
   repositories {
       jcenter()
   }
}

```

####Archivo de configuración de nivel de módulo

```java

/**
 * La primera linea aplica el plugin de Android para Gradle
 */

apply plugin: 'com.android.application'

/**
 * El bloque android {}  es donde se configuran todas las opciones 
 * relativas a Android.
 */

android {

  /**
   * compileSdkVersion especifica el nivel de API de Android que 
   * Gradle para compilar la aplicación. Esto significa que la 
   * aplicación puede usar funcionalidades del API incluidas en 
   * esta API o en APIs menores
   *
   * buildToolsVersion especifica la version del SDK build tools, 
   * utilidades de consola y compilador que Gradle utiliza para 
   * construir la aplicación
   */

  compileSdkVersion 25
  buildToolsVersion "25.0.0"

  /**
   * El bloque defaultConfig {} encapsula propiedades por defecto de 
   * todas las variantes de compilación y puede sobreescribir algunos 
   * atributos del main/AndroidManifest.xml dinamicamente.
   */

  defaultConfig {

    /**
     * applicationId identifica de manera única el paquete al momento de 
     * publicar.
     * Sin embargo, el código fuente deberá seguir referenciando 
     * al paquete definido en main/AndroidManifest.xml file.
     */

    applicationId 'com.example.myapp'

    // Define el nivel de API mínimo para correr la aplicación.
    minSdkVersion 15

    // Especifica el nivel de API usado para testear la aplicación.
    targetSdkVersion 25

    // Define el número de versión de la aplicación.
    versionCode 1

    // Define el nombre de versión de la aplicación.
    versionName "1.0"
  }

  /**
   * El bloque buildTypes {} es donde se puede configurar multiples 
   * tipos de compilación.
   * Por defecto, Gradle define dos tipos: debug y release. El tipo 
   * de compilación debug no se muestra explícitamente y esta firmado 
   * con la llave de debug por defecto. El tipo de compilación release 
   * aplica configuración de Proguard y no está firmado por defecto.
   */

  buildTypes {

    /**
     * Por defecto, Android Studio configura el modo de compilación 
     * release para hacer "shrink" del código y especifica el archivo 
     * de configuración de Proguard.
     */

    release {
        minifyEnabled true // Habilita el "shrink" del código.
        proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
    }
  }

  /**
   * El bloque productFlavors {} es donde se configura los diferentes 
   * flavors. Esto permite crear versiones distintas de la aplicación 
   * y pueden sobrreescribir el defaultConfig {} con sus propias 
   * configuraciones. 
   * Este ejemplo crea un flavor free y paid. Cada flavor especifica su 
   * propio application ID, de esta manera pueden existir en el Google 
   * Play Store o en el dispositivo Android de manera simultánea.
   */

  productFlavors {
    free {
      applicationId 'com.example.myapp.free'
    }

    paid {
      applicationId 'com.example.myapp.paid'
    }
  }

/**
 * El bloque de dependencies {} solo especifica dependencias 
 * necesitadas para compilar el mismo módulo.
 */

dependencies {
    compile project(":lib")
    compile 'com.android.support:appcompat-v7:25.1.0'
    compile fileTree(dir: 'libs', include: ['*.jar'])
}

```
####Archivo de propiedades de Gradle
Se ubican en el directorio raíz del proyecto.

 - gradle.properties: Dentro de este archivo se puede configurar ajustes de gradle para todo el proyecto como por ejemplo el tamaño máximo del daemon de Gradle.
 - local.properties: Dentro se configura propiedades del entorno local para el sistema de compilación como por ejemplo la ruta del SDK. Este archivo no debe ser incluido en el sistema de control de versión.

##Referencias

 - https://developer.android.com/studio/projects/index.html?hl=es-419
 - https://developer.android.com/studio/intro/index.html?hl=es-419
 - https://developer.android.com/studio/build/index.html?hl=es-419#build-process