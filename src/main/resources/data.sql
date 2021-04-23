INSERT INTO vacina_tbl (id , nome , lote) VALUES ('1','RAIVA','2021') ;
INSERT INTO vacina_tbl (id , nome , lote) VALUES ('2','TETANICA','2018') ;
INSERT INTO vacina_tbl (id , nome , lote) VALUES ('3','CASTRANTE','1999') ;

INSERT INTO animal_tbl (id,nome,raca,peso) VALUES ('1','Dogao' ,'SRD','60');
INSERT INTO animal_tbl (id,nome,raca,peso) VALUES ('2','Tocaio' ,'SRD','35');
INSERT INTO animal_tbl (id,nome,raca,peso) VALUES ('3','Mium' ,'SRD','15');

INSERT INTO  dono_tbl (id ,nome,CPF ,idade) VALUES ('1' ,'Riacho' ,'13319881795','25');
INSERT INTO  dono_tbl (id ,nome,CPF ,idade) VALUES ('2' ,'Locote' ,'23454300442','43');
INSERT INTO  dono_tbl (id ,nome,CPF ,idade) VALUES ('3' ,'Coxinha' ,'52523299031','60');

INSERT INTO user_tbl(id ,nome ,senha) VALUES ('1' ,'admin','$2a$10$KR4XuZ8H2jrKaGIbnrFJdu26HITV1UDS05bDsE1COzr6/dHbCDyPK');
INSERT INTO user_tbl(id ,nome ,senha) VALUES ('2' ,'user','$2a$10$RV9Z9SYRXyKIvmmil9Vf1u9Ni3KMmIiZQ6fp/YUyxPjajBjlOET.y');
INSERT INTO user_tbl(id ,nome ,senha) VALUES ('3' ,'123',' ');

INSERT INTO perfil_tbl(id,nome) VALUES ('1','ADMIN');
INSERT INTO perfil_tbl(id,nome) VALUES ('2','NORMIE')