-- Insert slots for Doctor 1 (some past, some future)
INSERT INTO slots (id, time, doctor_id, doctor_name, is_reserved, cost, created_at, updated_at)
VALUES
    ('b0d78b3b-9c8f-4e7c-bf1c-1d377758b697', '2023-01-15T10:30:00', 'a3f4f2b5-908a-47d7-96b4-6c10724b7b4e', 'Dr. Mohamed Saad', false, 150.00, NOW(), NOW()),
    ('96b0e107-97e9-4268-8528-b5a1bdb3b9f0', '2023-01-20T14:00:00', 'a3f4f2b5-908a-47d7-96b4-6c10724b7b4e', 'Dr. Mohamed Saad', true, 120.00, NOW(), NOW()),
    ('8f0a7122-52e3-47fa-b268-4739fdb8c5fa', '2027-02-10T09:30:00', 'a3f4f2b5-908a-47d7-96b4-6c10724b7b4e', 'Dr. Mohamed Saad', false, 180.00, NOW(), NOW()),
    ('6d1e93cc-c9f5-4bff-b95c-93fa6238c177', '2027-02-15T16:45:00', 'a3f4f2b5-908a-47d7-96b4-6c10724b7b4e', 'Dr. Mohamed Saad', false, 200.00, NOW(), NOW());

-- Insert slots for Doctor 2 (some past, some future)
INSERT INTO slots (id, time, doctor_id, doctor_name, is_reserved, cost, created_at, updated_at)
VALUES
    ('bfe65c91-cb09-4022-a1e5-3723c0b46d63', '2022-12-10T11:00:00', 'a234ea7d-8baf-46f9-bb36-e66c6c30dbe3', 'Dr. Domyaty', true, 250.00, NOW(), NOW()),
    ('7b3a74d9-e825-46ad-836d-7b0e8d7b43c4', '2023-03-05T08:30:00', 'a234ea7d-8baf-46f9-bb36-e66c6c30dbe3', 'Dr. Domyaty', false, 300.00, NOW(), NOW()),
    ('d4cfcd85-3e79-409b-bdbd-83307bda84c9', '2027-05-01T10:15:00', 'a234ea7d-8baf-46f9-bb36-e66c6c30dbe3', 'Dr. Domyaty', false, 275.00, NOW(), NOW()),
    ('b29f7a8c-973b-4d9b-a0e9-0f92592733f4', '2027-08-22T14:30:00', 'a234ea7d-8baf-46f9-bb36-e66c6c30dbe3', 'Dr. Domyaty', true, 400.00, NOW(), NOW());

-- Insert slots for Doctor 3 (mixed data)
INSERT INTO slots (id, time, doctor_id, doctor_name, is_reserved, cost, created_at, updated_at)
VALUES
    ('1995c56a-7bc3-43a7-b518-34a0f621c89e', '2021-07-15T09:00:00', 'be7c7746-8f59-45cf-bba0-23e5ef54c7d2', 'Dr. Nerdeen', true, 100.00, NOW(), NOW()),
    ('699cbde0-1a2e-48e6-bd95-b08cd4b122e1', '2027-12-25T17:00:00', 'be7c7746-8f59-45cf-bba0-23e5ef54c7d2', 'Dr. Nerdeen', false, 320.00, NOW(), NOW());
