# Tienda de Productos para el Cabello - Proyecto en Spring Boot Java

Este proyecto es una aplicación de gestión de una tienda de productos para el cabello desarrollada en Spring Boot Java. La aplicación permite la gestión de productos, proveedores, compras, control de pedidos, inicio de sesión de usuarios y la generación de recibos en formato PDF. También incluye un panel de control con información relevante sobre la recaudación e inventario actual.

## Características principales

- **Gestión de Productos:** Permite agregar, editar y eliminar productos de la tienda.

- **Gestión de Proveedores:** Facilita el registro y seguimiento de los proveedores de productos para el cabello.

- **Gestión de Compras:** Registra las compras de productos a los proveedores y actualiza automáticamente el inventario.

- **Control de Pedidos:** Permite a los usuarios gestionar el estado de los pedidos, desde la creación hasta la entrega.

- **Inicio de Sesión:** Proporciona un sistema de inicio de sesión seguro para usuarios administradores y empleados.

- **Generación de Recibos en PDF:** Permite generar recibos en formato PDF para las compras realizadas.

- **Panel de Control:** Ofrece un dashboard con información relevante sobre recaudación e inventario actual.

## Capturas de Pantalla

<img src="https://firebasestorage.googleapis.com/v0/b/examenmoviles-c1e55.appspot.com/o/Andy.png?alt=media&token=7ebbb334-9daa-4e86-bf75-36643bddfede" alt="Logo de Mi Tienda" width="50%" />
<img src="https://firebasestorage.googleapis.com/v0/b/examenmoviles-c1e55.appspot.com/o/2023-09-05%2016_32_36-Andy%26Curly%20y%203%20p%C3%A1ginas%20m%C3%A1s%20-%20Personal_%20Microsoft%E2%80%8B%20Edge.png?alt=media&token=ea270d44-5d6a-4c5e-82d2-8fe42e8b1127" alt="Logo de Mi Tienda" width="50%" />
<img src="https://firebasestorage.googleapis.com/v0/b/examenmoviles-c1e55.appspot.com/o/2023-09-05%2016_28_12-Agregar%20Productos%20al%20Carrito%20y%201%20p%C3%A1gina%20m%C3%A1s%20-%20Personal_%20Microsoft%E2%80%8B%20Edge.png?alt=media&token=c209dd3b-5ee7-4221-8ac6-1c06cf6a88e5" alt="Logo de Mi Tienda" width="50%" />
<img src="https://firebasestorage.googleapis.com/v0/b/examenmoviles-c1e55.appspot.com/o/2023-09-05%2016_29_28-Agregar%20Productos%20al%20Carrito%20y%201%20p%C3%A1gina%20m%C3%A1s%20-%20Personal_%20Microsoft%E2%80%8B%20Edge.png?alt=media&token=0820740a-6f6c-4b3e-af68-b588deced429" alt="Logo de Mi Tienda" width="50%" />
<img src="https://firebasestorage.googleapis.com/v0/b/examenmoviles-c1e55.appspot.com/o/2023-09-05%2016_29_51-Hoja%20de%20Vida%20Actualizada%202023%20-%20Word.png?alt=media&token=00792d22-612f-42ec-8eb7-955f8b2a11b2" alt="Logo de Mi Tienda" width="50%" />
<img src="https://firebasestorage.googleapis.com/v0/b/examenmoviles-c1e55.appspot.com/o/2023-09-05%2016_30_40-Recibo%20pdf%20y%202%20p%C3%A1ginas%20m%C3%A1s%20-%20Personal_%20Microsoft%E2%80%8B%20Edge.png?alt=media&token=68489974-3812-4896-904d-72f8a0cbc1e4" alt="Logo de Mi Tienda" width="50%" />

## Arquitectura MVC

El proyecto sigue una arquitectura Modelo-Vista-Controlador (MVC) para una estructura organizada y modular.

- **Modelo:** Contiene las clases que representan los datos y la lógica empresarial.

- **Vista:** Incluye las interfaces de usuario y las páginas web.

- **Controlador:** Gestiona las solicitudes HTTP y actúa como intermediario entre el modelo y la vista.

## Requisitos de instalación

Asegúrate de tener instalados los siguientes componentes antes de ejecutar la aplicación:

- Java JDK 11 o superior
- PostgreSQL (base de datos)
- Maven (para la construcción del proyecto)

## Pasos de instalación

1. Clona este repositorio en tu máquina local:
2. Configura la base de datos PostgreSQL. Puedes modificar las propiedades de conexión en el archivo application.properties.
3. Ejecuta el proyecto utilizando Maven: mvn spring-boot:run
