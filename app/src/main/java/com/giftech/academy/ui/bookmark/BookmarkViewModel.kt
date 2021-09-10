package com.giftech.academy.ui.bookmark

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.giftech.academy.data.source.local.entity.CourseEntity
import com.giftech.academy.data.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository):ViewModel() {

    fun getBookmarks(): LiveData<List<CourseEntity>> = academyRepository.getBookmarkedCourses()

}