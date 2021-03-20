package com.egstep.code.part.com.service

import com.egstep.code.entity.ComUserMst
import com.egstep.code.part.com.dto.GetUserIn
import com.egstep.code.repo.jpa.UserRepo
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping

@Service
class UserService {

    @Autowired lateinit var repo: UserRepo

    @GetMapping
    fun getUsers(input: GetUserIn) : List<ComUserMst> {
        val pageable = PageRequest.of(input.pageSize * (input.pageNum - 1), input.pageSize * (input.pageNum))
        return repo.findAll(pageable).toList()
    }
}