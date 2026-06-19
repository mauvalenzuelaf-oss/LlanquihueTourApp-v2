![Duoc UC](https://www.duoc.cl/wp-content/uploads/2022/09/logo-0.png)
# 🧠 Evaluación Sumativa 2 – Desarrollo Orientado a Objetos I

## 👤 Autor del proyecto
- **Nombre completo:** Mauricio Francisco Valenzuela Fuentes
- **Carrera:** Analista Programador Computacional
- **Sede:** Online

---

## 📘 Descripción general del sistema

Este proyecto corresponde a la Evaluación Sumativa N° 2 de la asignatura *Desarrollo Orientado a Objetos I*. Se trata de una versión ampliada de LlanquihueTourApp, una aplicación de consola desarrollada en Java para gestionar tours y personas vinculadas a la agencia turística Llanquihue Tour.

El sistema permite cargar información desde dos archivos de texto:
```plaintext
tours.txt: contiene los tours disponibles.

personas.txt: contiene las personas vinculadas a la empresa y sus respectivos cargos.
```
Cada línea de los archivos es procesada para crear objetos de las clases Tour, Persona y Cargo. Posteriormente, los objetos son almacenados en colecciones dinámicas ArrayList.

El programa también incorpora validaciones de datos, excepciones personalizadas, composición entre clases y diferentes filtros para mostrar información específica en la consola.

Los tipos de tour considerados son:

1. Ruta gastronómica.
2. Paseo lacustre.
3. Excursión cultural.
4. Tour personalizado.

Las relaciones posibles de una persona con Llanquihue Tour son:

1. Empleado.
2. Colaborador.
3. Proveedor.

---

## 🧱 Estructura general del proyecto

```plaintext
📁 LlanquihueTourApp-v2/
│
├── 📁 resources/
│   ├── personas.txt
│   └── tours.txt
│
└── 📁 src/
    ├── 📁 app/
    │   └── Main.java
    │
    ├── 📁 model/
    │   ├── Cargo.java
    │   ├── Persona.java
    │   └── Tour.java
    │
    ├── 📁 service/
    │   ├── GestorPersonas.java
    │   └── GestorTours.java
    │
    └── 📁 util/
        ├── CargoInvalidoException.java
        ├── PersonaInvalidaException.java
        ├── TourInvalidoException.java
        ├── ValidadorDatosCargo.java
        ├── ValidadorDatosPersona.java
        └── ValidadorDatosTour.java
```

---

## 🧩 Organización por paquetes

### 1. model

Contiene las clases que representan los objetos principales del sistema.
```plaintext
Tour.java: representa un tour turístico. Contiene nombre, tipo, ubicación y precio para una persona adulta.

Persona.java: representa una persona vinculada a Llanquihue Tour. Contiene nombre, relación con la empresa y un objeto de tipo Cargo.

Cargo.java: representa el cargo que desempeña una persona. Contiene nombre del cargo, organización, comuna y tiempo en el cargo.
```

### 2. service

Contiene las clases encargadas de leer los archivos externos y crear los objetos correspondientes.
```plaintext
GestorTours.java: lee el archivo tours.txt, separa los datos, valida su contenido y crea objetos de tipo Tour.

GestorPersonas.java: lee el archivo personas.txt, separa los datos, valida su contenido y crea objetos de tipo Persona y Cargo.
```

### 3. util

Contiene las clases encargadas de validar los datos y representar errores específicos del sistema.

Validadores:
```plaintext
ValidadorDatosTour.java
ValidadorDatosPersona.java
ValidadorDatosCargo.java
```
Excepciones personalizadas:
```plaintext
TourInvalidoException.java
PersonaInvalidaException.java
CargoInvalidoException.java
```
### 4. app

Contiene la clase principal del programa.
```plaintext
Main.java: ejecuta el sistema, carga las colecciones, muestra la información completa y aplica los filtros definidos.
```
---

## 📄 Formato del archivo de datos

Los archivos se encuentran dentro de la carpeta resources y utilizan el punto y coma (;) como separador.

### Archivo tours.txt

Cada línea debe seguir el siguiente formato:
```plaintext
nombre;tipo;ubicacion;precioAdulto
```

Ejemplo:
```plaintext
Ruta Gastronómica de Frutillar;ruta gastronomica;Frutillar;15000
```

### Archivo personas.txt

Cada línea debe seguir el siguiente formato:
```plaintext
nombre;relacionEmpresa;nombreCargo;organizacion;comunaCargo;tiempoCargo
```

Ejemplo:

```plaintext
Felipe Muñoz González;empleado;coordinador de operaciones;Llanquihue Tour;Llanquihue;3
```

---

## ⚙️ Instrucciones para clonar y ejecutar el proyecto

1. Clona el repositorio desde GitHub:
```plaintext
git clone https://github.com/mauvalenzuelaf-oss/LlanquihueTourApp-v2.git
```

2. Abre el proyecto en IntelliJ IDEA.

3. Verifica que la estructura del proyecto contenga las carpetas src y resources.

4. Confirma que los archivos tours.txt y personas.txt estén ubicados en:
```plaintext
resources/personas.txt
resources/tours.txt
```

5. Ejecuta el archivo Main.java desde el paquete app.

6. Revisa la salida por consola. El sistema mostrará primero el catálogo completo de tours, luego el catálogo completo de personas y, finalmente, listas filtradas por tipo de tour y tipo de persona.

---

## 🖥️ Ejemplo de salida esperada por consola

```plaintext
Tours cargados correctamente: 3
Personas cargadas correctamente: 2

===== CATÁLOGO DE TOURS LLANQUIHUE TOUR =====
Nombre: Ruta Gastronómica de Frutillar | Tipo: ruta gastronomica | Ubicación: Frutillar | Precio: $15000
Nombre: Sabores del Lago Llanquihue | Tipo: ruta gastronomica | Ubicación: Puerto Varas | Precio: $18000
Nombre: Paseo Lacustre Puerto Varas | Tipo: paseo lacustre | Ubicación: Puerto Varas | Precio: $22000

===== PERSONAS VINCULADAS =====
Nombre: Camila Soto Soto | Relación con la empresa: colaborador | Cargo: guia turistico | Organización: Independiente | Comuna: Puerto Varas | Tiempo en el cargo: 5 años
Nombre: Felipe Muñoz González | Relación con la empresa: empleado | Cargo: coordinador de operaciones | Organización: Llanquihue Tour | Comuna: Llanquihue | Tiempo en el cargo: 3 años

===== RUTAS GASTRONÓMICAS =====
Nombre: Ruta Gastronómica de Frutillar | Tipo: ruta gastronomica | Ubicación: Frutillar | Precio: $15000
Nombre: Sabores del Lago Llanquihue | Tipo: ruta gastronomica | Ubicación: Puerto Varas | Precio: $18000

===== EMPLEADOS =====
Nombre: Felipe Muñoz González | Relación con la empresa: empleado | Cargo: coordinador de operaciones | Organización: Llanquihue Tour | Comuna: Llanquihue | Tiempo en el cargo: 3 años
```

**Repositorio GitHub:** https://github.com/mauvalenzuelaf-oss/LlanquihueTourApp-v2.git

**Fecha de entrega:** 22/06/2026

---

© Duoc UC | Escuela de Informática y Telecomunicaciones |
