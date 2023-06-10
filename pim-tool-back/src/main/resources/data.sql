-- Inserting additional projects
INSERT INTO PROJECT (NAME, FINISHING_DATE)
VALUES
    ('Website Redesign', '2023-06-30'),
    ('Mobile App Development', '2023-07-15'),
    ('Marketing Campaign', '2023-08-10'),
    ('Product Launch', '2023-09-01'),
    ('Data Analysis Project', '2023-10-20'),
    ('E-commerce Website', '2023-11-30'),
    ('Social Media App', '2023-12-15'),
    ('Software Upgrade', '2024-01-10'),
    ('Research Study', '2024-02-28'),
    ('Event Management System', '2024-03-15');

-- Inserting additional users
INSERT INTO USER (USERNAME)
VALUES
    ('JohnDoe'),
    ('JaneSmith'),
    ('MichaelBrown'),
    ('EmilyDavis'),
    ('DavidJohnson'),
    ('SarahWilson'),
    ('AlexLee'),
    ('JessicaTaylor'),
    ('BrianMiller'),
    ('OliviaClark');

-- Inserting additional tasks
INSERT INTO TASK (NAME, DEADLINE, PROJECT_ID, USER_ID)
VALUES
    ('Design Homepage', '2023-06-20', 1, 1),
    ('Implement Login Functionality', '2023-06-25', 1, 2),
    ('Create Product Landing Page', '2023-07-05', 1, 3),
    ('Develop User Registration API', '2023-07-10', 2, 1),
    ('Design UI for Mobile App', '2023-07-15', 2, 4),
    ('Write Copy for Advertisements', '2023-08-05', 3, 2),
    ('Set up Email Marketing Campaign', '2023-08-10', 3, 3),
    ('Prepare Product Launch Event', '2023-09-01', 4, 4),
    ('Collect and Analyze Data', '2023-10-15', 5, 5),
    ('Design Website Layout', '2023-10-30', 5, 6),
    ('Develop Payment Gateway', '2023-11-15', 6, 7),
    ('Create User Profile Module', '2023-11-25', 6, 8),
    ('Implement Social Media Sharing', '2023-12-05', 7, 9),
    ('Optimize Software Performance', '2024-01-05', 8, 10),
    ('Conduct Surveys and Interviews', '2024-02-10', 9, 5),
    ('Build Event Registration System', '2024-02-20', 10, 7);
