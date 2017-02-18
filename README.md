# Android-Fundamentals-GMD
Android Fundamentals (23h)

### Lesson 6 : Fragments(4h)

## Temas :

- Fragments

- Comunicación entre componentes

- Ejemplos 

## 1. Fragments

### Fundamentos 

- ¿Qué es un Fragmento?

- Ciclo de Vida

- Interfaz de Usuario


### Crear un Fragmento

- Mediante XML

```java
   <fragment
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:name="com.gmd.lessons.fragments.views.AFragment"
        android:id="@+id/fragment" />
```

```
  private void app() {
        FragmentManager fragmentManager= getSupportFragmentManager();
        aFragment= (AFragment) fragmentManager.findFragmentById(R.id.fragment);
    }
```
- Programaticamente 

```java
   private void addFragment() {

        AFragment newFragment = new AFragment();
        Bundle args = new Bundle();
        args.putInt("POSITION", 1);
        args.putString("NAME", "MyFragment");
        newFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flayContainer, newFragment);
        //transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }
```

### Manejando Fragmentos 

- Stack

```java
   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.flayContainer, fragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
```

- Argumentos

```java
 Bundle bundle= new Bundle();
        bundle.putString("MESSAGE", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto");
        // Create new fragment and transaction
        MessageFragment messageFragment = new MessageFragment();
        messageFragment.setArguments(bundle);
```

```java
  private void extras() {
        if(getArguments()!=null){
            message= getArguments().getString("MESSAGE");
        }
    }
```

## 2. Comunicación entre fragments


### Ejemplos sobre fragments donde trataremos los siguientes puntos :

  * Agregar Fragments mediante XML.
     
  * Agregar y remover Fragments dinámicamente.
  
  * Enviar Información a un Fragment.
  
  * Manejando el Stack en Fragments.
     
  * Comunicación entre Fragments.
  
### Ejercicios 

  * Ejercicios sobre Fragments [Link](./Exercises.md); 
 
## Referencias :

- Dynamic UI with Fragments [https://developer.android.com/training/basics/fragments/index.html](https://developer.android.com/training/basics/fragments/index.html)

- Fragmens [https://developer.android.com/guide/components/fragments.html](https://developer.android.com/guide/components/fragments.html)
