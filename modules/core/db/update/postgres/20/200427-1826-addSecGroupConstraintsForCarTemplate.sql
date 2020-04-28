-- begin addSecGroupConstraintsForCarTemplate
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('1bff527c-1cbf-4d69-b2f9-ab97a8a8a074', current_timestamp, 'admin', 'itogovaya$CarTemplate', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForCarTemplate
