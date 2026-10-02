# Caso de estudio: cotización de logística farmacéutica

## Problema

Una operación de distribución necesita transportar cargas con distintos servicios. Un envío puede requerir empaque aislado; otro añade registro de temperatura y documentación de custodia. Ciertas cargas requieren un seguro según su valor y otras un manejo prioritario. Esas responsabilidades se combinan de forma independiente.

Crear una clase por combinación —por ejemplo, `EnvioRefrigeradoAseguradoPrioritario`— multiplica las variantes. Con cinco opciones binarias existen 32 subconjuntos, y el orden agrega más posibilidades cuando una operación usa el resultado de otra.

## Solución propuesta e implementada

Celsius implementa el transporte como `StandardShipment`. Los servicios opcionales implementan el mismo contrato mediante decoradores que contienen un `Shipment`. El cliente puede envolver una base en la cadena que necesita y consultar `quote()` sin conocer su estructura interna.

Las responsabilidades tienen distintos cálculos: cargo fijo, cargo por peso, porcentaje sobre el valor declarado, porcentaje sobre subtotal y modificación de plazo. Esto hace visible el valor de la composición más allá de sumar extras iguales.

## Alcance funcional

El usuario configura origen, destino, peso y valor declarado, selecciona cinco servicios disponibles, cambia su orden, calcula una cotización y descarga/imprime el resultado. La vista conecta cada servicio con su clase y con la expresión construida en Java.

La operación física se modela como una capacidad añadida. El proyecto no envía medicamentos, no captura temperaturas de sensores ni emite pólizas. Los escenarios y tarifas son ejemplos creados para el taller; los requisitos reales de productos farmacéuticos varían según la carga y el operador.

## Requisitos trazables

| Solicitud | Evidencia implementada |
|---|---|
| Caso de la vida real | Configuración modular de servicios logísticos farmacéuticos. |
| Aplicar Decorator | Interfaz común, base autónoma, wrapper abstracto y cinco wrappers concretos. |
| Frontend | Interfaz Thymeleaf, composición visual, datos y validaciones. |
| Java funcional | Cotización REST ejecutada por Spring Boot; JAR autónomo. |
| Complejidad moderada | Reglas variables, orden sensible, inmutabilidad y validación. |
| Carpetas y contexto | Estructura Maven, README, guías de caso y arquitectura. |

## Decisiones

Se usa un único proyecto Maven para que una sola aplicación sirva tanto la vista como la API. El frontend maneja selección y presentación; los importes provienen del dominio Java. Las respuestas son inmutables y no mantienen estado entre solicitudes. No se introduce base de datos porque la cotización es una función de su entrada.

El orden de los servicios es explícito. Prioridad aplica 20 % sobre su subtotal interior; su posición puede cambiar el total sin cambiar el conjunto de servicios. La aplicación permite explorar ese comportamiento y su conveniencia como regla de negocio.

## Beneficios y costos del patrón

Permite añadir servicios y combinar responsabilidades con un contrato estable. Evita duplicar el transporte base para cada variante y permite probar cada envoltura.

A cambio, introduce objetos y delegación recursiva. El orden requiere una regla definida; las capas deben mantener la semántica del contrato. El patrón no decide compatibilidades comerciales: si se requieren, deben validarse al ensamblar la cadena.
