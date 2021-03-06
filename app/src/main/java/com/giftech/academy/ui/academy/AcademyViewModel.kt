package com.giftech.academy.ui.academy

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.giftech.academy.data.AcademyRepository
import com.giftech.academy.data.source.local.entity.CourseEntity
import com.giftech.academy.vo.Resource

class AcademyViewModel(private val academyRepository: AcademyRepository) : ViewModel() {

    fun getCourses(): LiveData<Resource<PagedList<CourseEntity>>> =
            academyRepository.getAllCourses()
}

