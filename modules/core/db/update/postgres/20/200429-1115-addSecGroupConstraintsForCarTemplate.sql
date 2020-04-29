-- begin addSecGroupConstraintsForCarTemplate
insert into SEC_CONSTRAINT (ID, CREATE_TS, CREATED_BY, ENTITY_NAME, JOIN_CLAUSE, WHERE_CLAUSE, GROUP_ID) values 
('6967954c-a1b6-4139-827b-c7034ad84257', current_timestamp, 'admin', 'itogovaya$CarTemplate', ', ts$CardAcl acl', '{E}.id = acl.card.id and (acl.user.id = :session$userId or acl.global = true)', '8e6306e2-9e10-414a-b437-24c91ffef804')^

-- end addSecGroupConstraintsForCarTemplate
