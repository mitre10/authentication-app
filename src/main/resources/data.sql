-- User user/pass
INSERT INTO users (username, password, enabled, email, age)
  values ('user',
    '5db3547935b723b543cef39a819d49962cf11d9cb298a7501611f2e5be852cbd7dc2f59bb82bf91a',
    1,
    'user@company.com',
    29);

INSERT INTO users (username, password, enabled, email, age)
  values ('admin',
    '5db3547935b723b543cef39a819d49962cf11d9cb298a7501611f2e5be852cbd7dc2f59bb82bf91a',
    1,
    'admin@company.com',
    31);

INSERT INTO authorities (username, authority)
  values ('user', 'ROLE_USER');

  INSERT INTO authorities (username, authority)
    values ('admin', 'ROLE_ADMIN');