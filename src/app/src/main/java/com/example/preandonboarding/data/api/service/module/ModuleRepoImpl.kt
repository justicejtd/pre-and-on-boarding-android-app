package com.example.preandonboarding.data.api.service.module

import com.example.preandonboarding.data.model.Module
import retrofit2.Response

class ModuleRepoImpl(private val moduleService: ModuleService) : ModuleRepo {
    override suspend fun getModulesNames(): Response<List<Module>> = moduleService.getModules()
}