package com.example.ynetpostsapplication.domain.sport

import com.example.ynetpostsapplication.domain.YnetRepository
import com.example.ynetpostsapplication.domain.models.Culture
import com.example.ynetpostsapplication.domain.models.Sport
import com.example.ynetpostsapplication.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetSportUseCase @Inject constructor(
    private val repository: YnetRepository
){
    operator fun invoke(): Flow<Resource<List<Sport>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val allSport = repository.getSportFromApi()
                emit(Resource.Success(allSport))
            }
            catch (e: HttpException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured",data = null))
            }
            catch (e: Exception){
                emit(Resource.Error(e.localizedMessage ?: "Couldn't reach server check Internet connection",data = null))
            }
        }
    }
}