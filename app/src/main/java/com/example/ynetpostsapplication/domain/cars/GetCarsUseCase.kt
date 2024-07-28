package com.example.ynetpostsapplication.domain.cars

import com.example.ynetpostsapplication.domain.YnetRepository
import com.example.ynetpostsapplication.domain.models.Car
import com.example.ynetpostsapplication.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class GetCarsUseCase @Inject constructor(
    private val repository: YnetRepository
){
    operator fun invoke(): Flow<Resource<List<Car>>> {
        return flow {
            try {
                emit(Resource.Loading())
                val allCars = repository.getCarFromApi()
                emit(Resource.Success(allCars))
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