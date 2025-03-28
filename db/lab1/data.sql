INSERT INTO Patient (Name, Date) VALUES ('Ксения Кравчук', '2022-04-11');
INSERT INTO Child (parent_id, Gender, Height) VALUES (1, 'M', 120);
INSERT INTO City (Name, Weather, Country, Population) VALUES ('Байя анаско', 'Тропический дождь', 'Коста-Рика', 42125);
INSERT INTO Hospital (Roof_material, Type, City_id) VALUES ('Шифер', 'Роддом', 1);
INSERT INTO Doctor (Name, Profession, Hospital_id) VALUES ('Елена Моралес', 'Акушерка', 1);
INSERT INTO Event (Child_id, Name, Is_good) VALUES (1, 'Птица залетела в палату', true);
INSERT INTO doctor_patient (Doctor_id, Patient_id) VALUES (1, 1);