package com.giftech.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.data.source.AcademyRepository

class AcademyViewModel(private val academyRepository: AcademyRepository):ViewModel() {

    fun getCourses(): LiveData<List<CourseEntity>> = academyRepository.getAllCourses()

}