package com.example.preandonboarding.data.api.service.module

import com.example.preandonboarding.data.model.Module
import retrofit2.Response

interface ModuleRepo {
    /**
     * Returns a response with list of modules names related to the user company.
     * @return Response<ArrayList<Module>>
     */
    suspend fun getModulesNames(): Response<List<Module>>
}