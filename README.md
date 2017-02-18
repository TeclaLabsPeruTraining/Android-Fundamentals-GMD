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
```java

public class AFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentListener mListener;

    public AFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AFragment newInstance(String param1, String param2) {
        AFragment fragment = new AFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentListener) {
            mListener = (OnFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
```

- Ciclo de Vida

<img src="./images/fragments.png" height="480">

- Interfaz de Usuario

```java
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
```

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
