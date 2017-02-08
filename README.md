# Android-Fundamentals-GMD
Android Fundamentals (23h)

## Lesson2 : Componentes de Android (3h)

## Temas :

- Activity, Services, Broadcast Receiver, Content Providers

- Ciclo de vida de una aplicación. (Actividades y el “stack”)

- Archivo Manifest

- ¿Qué es un Intent y un Bundle?


### 1. Activity, Services, Broadcast Receiver, Content Providers

- Activity

- Services

- Broadcast Receiver

- Content Provider

- Actividades

    * Crear una actividad.
    
    * Reproducir un sonido usando un Servicio.
    
    * Ver el estado de la conexión Wifi mediante un Broadcast receiver.

### 2. Ciclo de vida de una aplicación. (Actividades y el “stack”)

- Actividades
    
    * Verificar el ciclo de vida de una actividad.

   ![imagen][google]
    
 
### 3. Android Manifest

- Actividades
    
    * Registrar una actividad en el manifest.
    
    * Cambiar la actividad que inicia por defecto.
    
    * Agregar permisos .
    
### 4. ¿Qué es un Intent y un Bundle?

- Intent

  Un intent se utiliza para la siguientes acciones:
  
  * Iniciar un actividad
  
  * Iniciar un servicio
  
  * Enviar mensajes o acciones a otras apps.
  
  Tipos :
  
   * Intent explícitos - Cuando se conoce el componente a iniciar. Por ejemplo lanzar una actividad en una aplicación.
   
   * Intent Implícitos - Cuando no se conoce el componente a invocar, pero se puede enviar acciones. Por ejemplo si deseamos lanzar el navegador de dispositivo desde nuestra aplicación.
    
- Bundle

- Actividades
    
    * Usar un intent para ir de una pantalla a otra.
    
    * Llamar un intent para lanzar al navegador.
    
    * Llamar un intent para lanzar a la cámara.
    
    * Enviar información de una actividad a otra.
    
    * Recibir información de un intent en una actividad.
    
    * Enviar objetos usando un intent.

## Referencias

- Android Manifest [https://developer.android.com/guide/topics/manifest/manifest-intro.html?hl=es](https://developer.android.com/guide/topics/manifest/manifest-intro.html?hl=es)

- Activity [https://developer.android.com/guide/components/activities/index.html](https://developer.android.com/guide/components/activities/index.html)

- Android Fundamentals [https://developer.android.com/guide/components/fundamentals.html](https://developer.android.com/guide/components/fundamentals.html)

- Intents [https://developer.android.com/guide/components/intents-filters.html?hl=es](https://developer.android.com/guide/components/intents-filters.html?hl=es)

[google]: https://developer.android.com/guide/components/images/activity_lifecycle.png
