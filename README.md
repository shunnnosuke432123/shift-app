# シフト管理アプリ

飲食店のシフト管理を想定した Web アプリケーション。
Java のコンソールアプリとして作成したものを、Spring Boot で Web アプリに移行した。

## 機能

- シフトの登録・一覧表示・編集・削除（CRUD）
- 出勤時間と退勤時間が同じ場合は「休み」として表示

## 技術構成

- Java 21
- Spring Boot 3
- Spring Data JPA
- Thymeleaf
- H2 Database

## 起動方法
```
./mvnw spring-boot:run
```
- 起動後 http://localhost:8080/shifts にアクセス。
