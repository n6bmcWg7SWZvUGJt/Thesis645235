-- begin ITOGOVAYA_CAR_MODEL
create table ITOGOVAYA_CAR_MODEL (
    ID uuid,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    VERSION integer,
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(50),
    CODE varchar(50),
    NOTE varchar(50),
    --
    primary key (ID)
)^
-- end ITOGOVAYA_CAR_MODEL
-- begin ITOGOVAYA_CAR_BASE
create table ITOGOVAYA_CAR_BASE (
    CARD_ID uuid,
    --
    NUMBER_ varchar(50),
    CAR_MODEL_ID uuid,
    NAME varchar(50),
    ISSUE date,
    PRICE decimal(19, 2),
    CAR_TYPE varchar(255),
    --
    -- from itogovaya$CarTemplate
    TEMPLATE_NAME varchar(255),
    GLOBAL_ boolean,
    --
    primary key (CARD_ID)
)^
-- end ITOGOVAYA_CAR_BASE
-- begin ITOGOVAYA_APPLICATION_FOR_PURCHASE_A_CAR
create table ITOGOVAYA_APPLICATION_FOR_PURCHASE_A_CAR (
    CARD_ID uuid,
    --
    CAR_ID uuid,
    CAR_CONTRACTOR_ID uuid,
    BANK_ID uuid,
    CAR_PAID boolean,
    --
    primary key (CARD_ID)
)^
-- end ITOGOVAYA_APPLICATION_FOR_PURCHASE_A_CAR
--Add default numerator for itogovaya$Car
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
    cnt integer = 0;
BEGIN
cnt = (select count(id) from DF_NUMERATOR where CODE = 'CarNumerator' and delete_ts is null);
if(cnt = 0) then
    INSERT INTO DF_NUMERATOR (ID, CREATE_TS, CREATED_BY, VERSION, CODE, NUMERATOR_FORMAT, SCRIPT_ENABLED,
    PERIODICITY, NUMBER_INITIAL_VALUE, LOC_NAME)
    VALUES ('a7a8478d-6d70-4447-a611-4c389602341c', now(), 'system', 1, 'CarNumerator', '[number]', FALSE, 'Y', 1,
    '{"captionWithLanguageList":[{"language":"ru","caption":"Car"},{"language":"en","caption":"Car"}]}'
    );
end if;

return 0;
END;
$$
LANGUAGE plpgsql;
^

select baseInsert()^
drop function if exists baseInsert()^
--Add default numerator for itogovaya$ApplicationForPurchaseACar
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
    cnt integer = 0;
BEGIN
cnt = (select count(id) from DF_NUMERATOR where CODE = 'ApplicationForPurchaseACarNumerator' and delete_ts is null);
if(cnt = 0) then
    INSERT INTO DF_NUMERATOR (ID, CREATE_TS, CREATED_BY, VERSION, CODE, NUMERATOR_FORMAT, SCRIPT_ENABLED,
    PERIODICITY, NUMBER_INITIAL_VALUE, LOC_NAME)
    VALUES ('e7c60ec8-6ede-44aa-a597-39bbb3f1d0c1', now(), 'system', 1, 'ApplicationForPurchaseACarNumerator', '[number]', FALSE, 'Y', 1,
    '{"captionWithLanguageList":[{"language":"ru","caption":"ApplicationForPurchaseACar"},{"language":"en","caption":"ApplicationForPurchaseACar"}]}'
    );
end if;

return 0;
END;
$$
LANGUAGE plpgsql;
^

select baseInsert()^
drop function if exists baseInsert()^
--Insert new doc type for itogovaya$ApplicationForPurchaseACar
insert into TS_CARD_TYPE (ID, CREATE_TS, CREATED_BY, NAME, DISCRIMINATOR,FIELDS_XML) values ('f0817def-efc4-4841-b41b-8bc62ca33cc0', current_timestamp, 'admin', 'itogovaya$ApplicationForPurchaseACar', 1100, '')^
--Add default doc kind for itogovaya$ApplicationForPurchaseACar
CREATE OR REPLACE FUNCTION baseInsert()
RETURNS integer
AS $$
DECLARE
cnt integer = 0;
BEGIN
cnt = (select count(CATEGORY_ID) from DF_DOC_KIND where category_id = '21546f47-fe8a-4fa2-9dbc-61ceb9b78902');
if(cnt = 0) then
    insert into SYS_CATEGORY (ID, NAME, ENTITY_TYPE, IS_DEFAULT, CREATE_TS, CREATED_BY, VERSION, DISCRIMINATOR)
    values ( '21546f47-fe8a-4fa2-9dbc-61ceb9b78902', 'Заявка на покупку автомобиля', 'itogovaya$ApplicationForPurchaseACar', false, now(), USER, 1, 1);
    insert into DF_DOC_KIND (category_id, create_ts, created_by, version, doc_type_id, numerator_id, 
    numerator_type, category_attrs_place, tab_name, portal_publish_allowed, disable_add_process_actors, create_only_by_template)
    values ('21546f47-fe8a-4fa2-9dbc-61ceb9b78902', 'now()', 'admin', 1, 'f0817def-efc4-4841-b41b-8bc62ca33cc0', 'e7c60ec8-6ede-44aa-a597-39bbb3f1d0c1', 
    1, 1, 'Р”РѕРї. РїРѕР»СЏ', false, false, false);
end if;return 0;
END;
$$
LANGUAGE plpgsql;
^
select baseInsert();
^
drop function if exists baseInsert()^
--Update process card_types for entity itogovaya$ApplicationForPurchaseACar
update wf_proc set card_types = regexp_replace(card_types, E',itogovaya\\$ApplicationForPurchaseACar', '') where code in ('Endorsement','Resolution','Acquaintance','Registration')^
update wf_proc set updated_by='admin', card_types = card_types || 'itogovaya$ApplicationForPurchaseACar,' where code in ('Endorsement','Resolution','Acquaintance','Registration')^
--Update security for entity itogovaya$ApplicationForPurchaseACar
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:create',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:update',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:delete',0,(select ID from SEC_ROLE where NAME = 'SimpleUser'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:create',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:update',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:delete',1,(select ID from SEC_ROLE where NAME = 'Administrators'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:create',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:update',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));
insert into SEC_PERMISSION (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, PERMISSION_TYPE, TARGET, VALUE, ROLE_ID) values (newid(),now(),'system',1,now(),null,null,null,20,'itogovaya$ApplicationForPurchaseACar:delete',1,(select ID from SEC_ROLE where NAME = 'doc_initiator'));

-- begin addSecGroupConstraintsForCar
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('7cec0326-65e2-4cbf-9792-247620f04202', current_timestamp, 'admin', 'itogovaya$Car', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForCar

-- begin addSecGroupConstraintsForCarTemplate
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('508d9c4f-1ea1-4f67-bd93-c4f296dcd568', current_timestamp, 'admin', 'itogovaya$CarTemplate', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForCarTemplate
