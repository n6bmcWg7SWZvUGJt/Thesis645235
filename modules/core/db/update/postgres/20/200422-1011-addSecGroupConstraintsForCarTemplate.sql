-- begin addSecGroupConstraintsForCarTemplate
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('d36e9a00-bd84-4911-bde8-cb266e3c7a4f', current_timestamp, 'admin', 'itogovaya$CarTemplate', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForCarTemplate
