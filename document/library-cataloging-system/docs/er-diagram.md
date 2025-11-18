```mermaid
erDiagram
    BOOK {
        int id
        string title
        string isbn
        int publisher_id
    }
    AUTHOR {
        int id
        string name
    }
    BOOK_AUTHOR {
        int book_id
        int author_id
    }
    LOAN {
        int id
        int book_id
        date loan_date
        date return_date
    }
    BASE_USER {
        int id
        string username
        string email
        string password_hash
        string role       "USER / ADMIN"
        datetime created_at
        datetime updated_at
    }
    ACTIVE_USER {
        int base_user_id
        datetime last_login_at
    }
    DELETED_USER {
        int base_user_id
        datetime deleted_at
    }

    BOOK ||--o{ BOOK_AUTHOR : "has"
    AUTHOR ||--o{ BOOK_AUTHOR : "writes"
    BOOK ||--o{ LOAN : "is borrowed in"
    BASE_USER ||--|| ACTIVE_USER : has
    BASE_USER ||--|| DELETED_USER : has
```
