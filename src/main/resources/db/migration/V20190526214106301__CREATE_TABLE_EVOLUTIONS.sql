CREATE TABLE digidex_digivolution (
     id_digidex int4 references digidex(id),
     id_digidex_digivolution int4 references digidex(id),
     PRIMARY KEY (id_digidex, id_digidex_digivolution)
);