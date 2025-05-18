Iniciando...
Probando el servicio...
Framework y servicio iniciado...
Insertar incidencia correcta
Hibernate: 
    select
        conductor0_.nif as nif1_0_0_,
        conductor0_.apellido as apellido2_0_0_,
        conductor0_.ciudad as ciudad3_0_0_,
        conductor0_.cp as cp4_0_0_,
        conductor0_.direccion as direccion5_0_0_,
        conductor0_.nombre as nombre6_0_0_,
        conductor0_.puntos as puntos7_0_0_,
        conductor0_.IDAUTO as idauto8_0_0_,
        vehiculo1_.idauto as idauto1_3_1_,
        vehiculo1_.ciudad as ciudad2_3_1_,
        vehiculo1_.cp as cp3_3_1_,
        vehiculo1_.direccion as direccion4_3_1_,
        vehiculo1_.nombre as nombre5_3_1_ 
    from
        HR.Conductor conductor0_ 
    left outer join
        HR.Vehiculo vehiculo1_ 
            on conductor0_.IDAUTO=vehiculo1_.idauto 
    where
        conductor0_.nif=?
Hibernate: 
    select
        tipoincide0_.id as id1_2_0_,
        tipoincide0_.descripcion as descripcion2_2_0_,
        tipoincide0_.valor as valor3_2_0_ 
    from
        HR.TipoIncidencia tipoincide0_ 
    where
        tipoincide0_.id=?
Hibernate: 
    select
        incidencia0_.NIF as nif2_1_0_,
        incidencia0_.fecha as fecha1_1_0_,
        incidencia0_.fecha as fecha1_1_1_,
        incidencia0_.NIF as nif2_1_1_,
        incidencia0_.anotacion as anotacion3_1_1_,
        incidencia0_.IDTIPO as idtipo4_1_1_,
        tipoincide1_.id as id1_2_2_,
        tipoincide1_.descripcion as descripcion2_2_2_,
        tipoincide1_.valor as valor3_2_2_ 
    from
        HR.Incidencia incidencia0_ 
    left outer join
        HR.TipoIncidencia tipoincide1_ 
            on incidencia0_.IDTIPO=tipoincide1_.id 
    where
        incidencia0_.NIF=?
Hibernate: 
    /* insert es.ubu.lsi.model.multas.Incidencia
        */ insert 
        into
            HR.Incidencia
            (IDTIPO, fecha, NIF, anotacion) 
        values
            (?, ?, ?, ?)
Hibernate: 
    /* update
        es.ubu.lsi.model.multas.Conductor */ update
            HR.Conductor 
        set
            apellido=?,
            ciudad=?,
            cp=?,
            direccion=?,
            nombre=?,
            puntos=?,
            IDAUTO=? 
        where
            nif=?
	OK incidencia bien insertada
	OK actualiza bien los puntos del conductor
Insertar incidencia con tipo erróneo
Hibernate: 
    select
        conductor0_.nif as nif1_0_0_,
        conductor0_.apellido as apellido2_0_0_,
        conductor0_.ciudad as ciudad3_0_0_,
        conductor0_.cp as cp4_0_0_,
        conductor0_.direccion as direccion5_0_0_,
        conductor0_.nombre as nombre6_0_0_,
        conductor0_.puntos as puntos7_0_0_,
        conductor0_.IDAUTO as idauto8_0_0_,
        vehiculo1_.idauto as idauto1_3_1_,
        vehiculo1_.ciudad as ciudad2_3_1_,
        vehiculo1_.cp as cp3_3_1_,
        vehiculo1_.direccion as direccion4_3_1_,
        vehiculo1_.nombre as nombre5_3_1_ 
    from
        HR.Conductor conductor0_ 
    left outer join
        HR.Vehiculo vehiculo1_ 
            on conductor0_.IDAUTO=vehiculo1_.idauto 
    where
        conductor0_.nif=?
Hibernate: 
    select
        tipoincide0_.id as id1_2_0_,
        tipoincide0_.descripcion as descripcion2_2_0_,
        tipoincide0_.valor as valor3_2_0_ 
    from
        HR.TipoIncidencia tipoincide0_ 
    where
        tipoincide0_.id=?
	OK detecta correctamente que NO existe ese tipo de incidencia
Indulto del conductor...
Hibernate: 
    select
        conductor0_.nif as nif1_0_0_,
        conductor0_.apellido as apellido2_0_0_,
        conductor0_.ciudad as ciudad3_0_0_,
        conductor0_.cp as cp4_0_0_,
        conductor0_.direccion as direccion5_0_0_,
        conductor0_.nombre as nombre6_0_0_,
        conductor0_.puntos as puntos7_0_0_,
        conductor0_.IDAUTO as idauto8_0_0_,
        vehiculo1_.idauto as idauto1_3_1_,
        vehiculo1_.ciudad as ciudad2_3_1_,
        vehiculo1_.cp as cp3_3_1_,
        vehiculo1_.direccion as direccion4_3_1_,
        vehiculo1_.nombre as nombre5_3_1_ 
    from
        HR.Conductor conductor0_ 
    left outer join
        HR.Vehiculo vehiculo1_ 
            on conductor0_.IDAUTO=vehiculo1_.idauto 
    where
        conductor0_.nif=?
Hibernate: 
    /* Incidencia.deleteAllWithNIF */ delete 
    from
        HR.Incidencia 
    where
        NIF=?
Hibernate: 
    select
        incidencia0_.NIF as nif2_1_0_,
        incidencia0_.fecha as fecha1_1_0_,
        incidencia0_.fecha as fecha1_1_1_,
        incidencia0_.NIF as nif2_1_1_,
        incidencia0_.anotacion as anotacion3_1_1_,
        incidencia0_.IDTIPO as idtipo4_1_1_,
        tipoincide1_.id as id1_2_2_,
        tipoincide1_.descripcion as descripcion2_2_2_,
        tipoincide1_.valor as valor3_2_2_ 
    from
        HR.Incidencia incidencia0_ 
    left outer join
        HR.TipoIncidencia tipoincide1_ 
            on incidencia0_.IDTIPO=tipoincide1_.id 
    where
        incidencia0_.NIF=?
Hibernate: 
    /* update
        es.ubu.lsi.model.multas.Conductor */ update
            HR.Conductor 
        set
            apellido=?,
            ciudad=?,
            cp=?,
            direccion=?,
            nombre=?,
            puntos=?,
            IDAUTO=? 
        where
            nif=?
	OK todas las incidencias borradas del conductor indultado
	OK puntos bien iniciados con indulto 
	OK el número de incidencias de otros conductores es correcto
Indultar a un conductor que no existe
Hibernate: 
    select
        conductor0_.nif as nif1_0_0_,
        conductor0_.apellido as apellido2_0_0_,
        conductor0_.ciudad as ciudad3_0_0_,
        conductor0_.cp as cp4_0_0_,
        conductor0_.direccion as direccion5_0_0_,
        conductor0_.nombre as nombre6_0_0_,
        conductor0_.puntos as puntos7_0_0_,
        conductor0_.IDAUTO as idauto8_0_0_,
        vehiculo1_.idauto as idauto1_3_1_,
        vehiculo1_.ciudad as ciudad2_3_1_,
        vehiculo1_.cp as cp3_3_1_,
        vehiculo1_.direccion as direccion4_3_1_,
        vehiculo1_.nombre as nombre5_3_1_ 
    from
        HR.Conductor conductor0_ 
    left outer join
        HR.Vehiculo vehiculo1_ 
            on conductor0_.IDAUTO=vehiculo1_.idauto 
    where
        conductor0_.nif=?
	OK detecta correctamente que NO existe ese conductor
Información completa con grafos de entidades...
Hibernate: 
    /* Vehiculo.findAll */ select
        vehiculo0_.idauto as idauto1_3_0_,
        conductore1_.nif as nif1_0_1_,
        incidencia2_.fecha as fecha1_1_2_,
        incidencia2_.NIF as nif2_1_2_,
        tipoincide3_.id as id1_2_3_,
        vehiculo0_.ciudad as ciudad2_3_0_,
        vehiculo0_.cp as cp3_3_0_,
        vehiculo0_.direccion as direccion4_3_0_,
        vehiculo0_.nombre as nombre5_3_0_,
        conductore1_.apellido as apellido2_0_1_,
        conductore1_.ciudad as ciudad3_0_1_,
        conductore1_.cp as cp4_0_1_,
        conductore1_.direccion as direccion5_0_1_,
        conductore1_.nombre as nombre6_0_1_,
        conductore1_.puntos as puntos7_0_1_,
        conductore1_.IDAUTO as idauto8_0_1_,
        conductore1_.IDAUTO as idauto8_0_0__,
        conductore1_.nif as nif1_0_0__,
        incidencia2_.anotacion as anotacion3_1_2_,
        incidencia2_.IDTIPO as idtipo4_1_2_,
        incidencia2_.NIF as nif2_1_1__,
        incidencia2_.fecha as fecha1_1_1__,
        tipoincide3_.descripcion as descripcion2_2_3_,
        tipoincide3_.valor as valor3_2_3_ 
    from
        HR.Vehiculo vehiculo0_ 
    left outer join
        HR.Conductor conductore1_ 
            on vehiculo0_.idauto=conductore1_.IDAUTO 
    left outer join
        HR.Incidencia incidencia2_ 
            on conductore1_.nif=incidencia2_.NIF 
    left outer join
        HR.TipoIncidencia tipoincide3_ 
            on incidencia2_.IDTIPO=tipoincide3_.id
es.ubu.lsi.model.multas.Vehiculo@36df4c26
	Conductor [nif=10000000A, nombre=Juana, apellido=Manzanal, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@5a4c98d7, puntos=3]
		es.ubu.lsi.model.multas.Incidencia@38732372
		es.ubu.lsi.model.multas.Incidencia@2fee69a1
	Conductor [nif=10000000C, nombre=Jimena, apellido=Plaza, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@668a32a4, puntos=12]
	Conductor [nif=10000000B, nombre=Javier, apellido=Calle, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@2026fbff, puntos=6]
		es.ubu.lsi.model.multas.Incidencia@6a4af081
es.ubu.lsi.model.multas.Vehiculo@36b53f08
	Conductor [nif=20000000C, nombre=Pablo, apellido=Torquemada, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@baa227e, puntos=3]
		es.ubu.lsi.model.multas.Incidencia@590013c7
		es.ubu.lsi.model.multas.Incidencia@64f32e9e
	Conductor [nif=20000000A, nombre=Paloma, apellido=Del Barrio, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@351e89fc, puntos=12]
	Conductor [nif=20000000B, nombre=Pedro, apellido=Medina, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@2b682e9, puntos=12]
es.ubu.lsi.model.multas.Vehiculo@7b211077
	Conductor [nif=30000000A, nombre=Raquel, apellido=Del Barrio, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@15586843, puntos=9]
		es.ubu.lsi.model.multas.Incidencia@62b0bf85
	Conductor [nif=30000000C, nombre=Roberto, apellido=Manzanita, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@4fbb1144, puntos=0]
		es.ubu.lsi.model.multas.Incidencia@734fbae3
	Conductor [nif=30000000B, nombre=Rosa, apellido=Manzanedo, direccionPostal=es.ubu.lsi.model.multas.DireccionPostal@e2b3026, puntos=6]
		es.ubu.lsi.model.multas.Incidencia@6c9bf3b5
OK Sin excepciones en la consulta completa y acceso posterior
FIN.............