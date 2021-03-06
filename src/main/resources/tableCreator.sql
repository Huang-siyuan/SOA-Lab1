create table coordinates
(
    id serial
        constraint coordinates_pk
            primary key,
    x  integer          not null
        constraint vehicle_coordinate_x_check
            check (x > '-479'::integer),
    y  double precision not null
        constraint vehicle_coordinate_y_check
            check (y > ('-89'::integer)::double precision)
);

create table vehicle
(
    id                 bigserial
        constraint vehicle_pk
            primary key,
    name               varchar(50)      not null
        constraint vehicle_name_check
            check ((name)::text <> ''::text),
    creation_date      date             not null,
    engine_power       double precision not null
        constraint vehicle_engine_power_check
            check (engine_power > (0)::double precision),
    fuel_consumption   bigint           not null
        constraint vehicle_fuel_consumption_check
            check (fuel_consumption > 0),
    distance_travelled bigint
        constraint vehicle_distance_travelled_check
            check (distance_travelled >= 0),
    fuel_type varchar(10) not null
        constraint fuel_type_check
            check (((fuel_type)::text = 'KEROSENE'::text) OR ((fuel_type)::text = 'DIESEL'::text) OR
                   ((fuel_type)::text = 'MANPOWER'::text) OR ((fuel_type)::text = 'NUCLEAR'::text) OR
                   ((fuel_type)::text = 'PLASMA'::text)),
    coordinates_id      integer          not null
        constraint "FK_vehicle_coordinates"
            references coordinates(id)
);


-- 02/07 Change the id type of the vehicle table to bigserial.
-- Cause it's the Long.

