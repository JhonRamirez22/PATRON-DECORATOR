# Guía de exposición del taller

## Presentación del problema

Explica una operación de transporte que ofrece servicios opcionales para carga farmacéutica. La misma ruta puede llevar un paquete común, uno aislado con registro de temperatura o una carga asegurada y prioritaria. El desafío es combinar esas responsabilidades sin escribir una clase por variante.

## Demostración

1. Abre Celsius y selecciona **Solo transporte**. Muestra que `StandardShipment` funciona por sí solo.
2. Añade **Empaque refrigerado** y calcula. Señala `ColdChainDecorator`, su costo y la capacidad añadida.
3. Añade **Registro de temperatura**. Muestra que conserva `Shipment` y envuelve al envío anterior.
4. Abre la expresión Java. Sigue la llamada desde el decorador exterior hasta la base y el resultado de vuelta.
5. Usa Bogotá → Medellín, 2 kg y $1.500.000. Deja únicamente Seguro y Prioridad.
6. Con Seguro antes que Prioridad, calcula **$65.280**. Invierte el orden: calcula **$61.680**. El seguro tiene el mismo costo; la prioridad recibe un subtotal distinto.
7. Descarga el JSON y relaciona sus líneas con las clases del proyecto.

## Recorrido por el código

Abre `Shipment.java` para mostrar el contrato. Continúa con `StandardShipment.java`, `ShipmentDecorator.java` y `PriorityDecorator.java`. Termina en `QuoteService.calculate()`, donde cada asignación envuelve la referencia anterior.

La clase abstracta no concentra las tarifas: contiene la referencia interior. La lógica pertenece a cada decorador concreto y los resultados son inmutables. La composición cambia en ejecución a partir de la selección del usuario.

## Preguntas para discutir

- ¿Qué se gana frente a crear una subclase por combinación?
- ¿Qué decoradores son independientes del orden y cuál utiliza el subtotal interior?
- ¿Por qué es útil que base y envolturas cumplan el mismo contrato?
- ¿Dónde introducirías restricciones comerciales entre servicios?
- ¿Cómo añadirías firma de recepción sin modificar `StandardShipment`?

## Cierre

El proyecto satisface el caso aplicado, la implementación Java y el frontend. El cálculo está implementado; las operaciones logísticas están representadas como capacidades y los precios son datos del taller. La complejidad surge de reglas distintas y de la composición explícita, no de infraestructura adicional.
