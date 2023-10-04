package com.example.user.adapter.out.persistence.entity

import jakarta.persistence.*

@Entity
@Table(name = "users")
class UserEntity (
    name: String,
    email: String,
    password: String
) : BaseTimeEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",  updatable = false, nullable = false,)
    val id: Long? = null

    @Column(name = "name")
    var name: String = name

    @Column(name = "email")
    var email: String = email

    @Column(name = "password")
    var password: String = password
}
