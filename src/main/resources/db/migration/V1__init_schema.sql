CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- =========================
-- users
-- =========================
CREATE TABLE users (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    email VARCHAR(255) UNIQUE NOT NULL,
    password TEXT NOT NULL,
    role VARCHAR(20) DEFAULT 'USER',
    isactive BOOLEAN DEFAULT TRUE,

    CONSTRAINT chk_role CHECK ( role in ('ADMIN', 'USER'))
);

-- =========================
-- profiles
-- =========================
CREATE TABLE profiles (
    id UUID PRIMARY KEY,
    userId UUID UNIQUE NOT NULL,
    imageUrl VARCHAR(100),
    username VARCHAR(100) UNIQUE NOT NULL,
    biography TEXT,
    userprofile VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users(id) ON DELETE CASCADE
);

-- =========================
-- categories
-- =========================
CREATE TABLE categories (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT
);

-- =========================
-- userpreferences
-- =========================
CREATE TABLE userpreferences (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     userid UUID NOT NULL,
     categoryid UUID NOT NULL,
     FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE,
     FOREIGN KEY (categoryid) REFERENCES categories(id) ON DELETE CASCADE,

    CONSTRAINT uniqueusercategory UNIQUE (userid, categoryid)
);

-- =========================
-- posts
-- =========================
CREATE TABLE posts (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     authorid UUID NOT NULL,
     title VARCHAR(255),
     slug VARCHAR(255) UNIQUE,
     content TEXT,
     coverimageurl TEXT,
     published BOOLEAN,
     publishedat TIMESTAMP,

     FOREIGN KEY (authorid) REFERENCES users(id) ON DELETE CASCADE
);

-- =========================
-- postcategories
-- =========================
CREATE TABLE postcategories (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     postid UUID NOT NULL,
     categoryid UUID NOT NULL,

     FOREIGN KEY (postid) REFERENCES posts(id) ON DELETE CASCADE,
     FOREIGN KEY (categoryid) REFERENCES categories(id) ON DELETE CASCADE,

     CONSTRAINT uniquepostcategory UNIQUE (postid, categoryid)
);

-- =========================
-- tags
-- =========================
CREATE TABLE tags (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     name VARCHAR(50) UNIQUE NOT NULL
);

-- =========================
-- posttags
-- =========================
CREATE TABLE posttags (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     postid UUID NOT NULL,
     tagid UUID NOT NULL,

     FOREIGN KEY (postid) REFERENCES posts(id) ON DELETE CASCADE,
     FOREIGN KEY (tagid) REFERENCES tags(id) ON DELETE CASCADE,

     CONSTRAINT uniqueposttag UNIQUE (postid, tagid)
);

-- =========================
-- comments
-- =========================
CREATE TABLE comments (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     postid UUID NOT NULL,
     authorid UUID NOT NULL,
     parentid UUID,
     content TEXT,

     FOREIGN KEY (postid) REFERENCES posts(id) ON DELETE CASCADE,
     FOREIGN KEY (authorid) REFERENCES users(id) ON DELETE CASCADE,
     FOREIGN KEY (parentid) REFERENCES comments(id) ON DELETE CASCADE
);

-- =========================
-- postimages
-- =========================
CREATE TABLE postimages (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     postid UUID NOT NULL,
     imageurl TEXT,
     position INTEGER,

     FOREIGN KEY (postid) REFERENCES posts(id) ON DELETE CASCADE
);

-- =========================
-- followers
-- =========================
CREATE TABLE followers (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     followerid UUID NOT NULL,
     followingid UUID NOT NULL,

     FOREIGN KEY (followerid) REFERENCES users(id) ON DELETE CASCADE,
     FOREIGN KEY (followingid) REFERENCES users(id) ON DELETE CASCADE,

     CONSTRAINT uniquefollow UNIQUE (followerid, followingid)
);

-- =========================
-- postlikes
-- =========================
CREATE TABLE postlikes (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     userid UUID NOT NULL,
     postid UUID NOT NULL,

     FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE,
     FOREIGN KEY (postid) REFERENCES posts(id) ON DELETE CASCADE,

     CONSTRAINT uniquepostlike UNIQUE (userid, postid)
);

-- =========================
-- favorites
-- =========================
CREATE TABLE favorites (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     userid UUID NOT NULL,
     postid UUID NOT NULL,
     FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE,
     FOREIGN KEY (postid) REFERENCES posts(id) ON DELETE CASCADE,

     CONSTRAINT uniquefavorite UNIQUE (userid, postid)
);

-- =========================
-- commentlikes
-- =========================
CREATE TABLE commentlikes (
     id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
     userid UUID NOT NULL,
     commentid UUID NOT NULL,

     FOREIGN KEY (userid) REFERENCES users(id) ON DELETE CASCADE,
     FOREIGN KEY (commentid) REFERENCES comments(id) ON DELETE CASCADE,

     CONSTRAINT uniquecommentlike UNIQUE (userid, commentid)
);