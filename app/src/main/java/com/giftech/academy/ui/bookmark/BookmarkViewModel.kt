package com.giftech.academy.ui.bookmark

import androidx.lifecycle.ViewModel
import com.giftech.academy.data.CourseEntity
import com.giftech.academy.data.source.AcademyRepository

class BookmarkViewModel(private val academyRepository: AcademyRepository):ViewModel() {

    fun getBookmarks(): List<CourseEntity> = academyRepository.getBookmarkedCourses()

}