--
-- Despejando dados para a tabela `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

--
-- Despejando dados para a tabela `tbg_authority`
--

INSERT INTO `tbg_authority` (`authority_id`, `authority_description`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');

--
-- Despejando dados para a tabela `tbg_user`
--

INSERT INTO `tbg_user` (`user_id`, `user_email`, `user_full_name`, `user_hash_password`, `username`) VALUES
(1, 'wellington@gmil.com', 'Wellington da Silva Melo', '$2a$10$FfXxdwLKjyb7I03Lzehol.C90o6Rp/OUg4RfbGwpCxFbyCX8WD58W', 'admin'),
(3, 'midia@gmail.com', 'Midia', '$2a$10$MMv/WpU/QrUwXFclJRGvj.kGz7mxU67vkyYE8TiV5nkj9sdylgOfi', 'tomwelss'),
(5, 'jupmelo@gmail.com', 'Júlia Pereira de Melo Silva', '$2a$10$ovxmQxTtZgiZPToI6aMX3upjUKNHxVAiFldHzNfNnaSG.QKW.zzum', 'jupmelo');

--
-- Despejando dados para a tabela `tbg_user_authority`
--

INSERT INTO `tbg_user_authority` (`user_authority_id`, `authority_id`, `user_id`) VALUES
(1, 1, 1),
(4, 2, 3),
(6, 2, 5);

