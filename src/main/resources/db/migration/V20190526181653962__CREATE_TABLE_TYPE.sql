CREATE TABLE digidex_type (
	"name" VARCHAR(50) NOT NULL PRIMARY KEY
);

CREATE TABLE digidex_digidextype (
    id_digidex int4 references digidex(id),
    name_type VARCHAR(50) references digidex_type("name"),
    PRIMARY KEY (id_digidex, name_type)
);