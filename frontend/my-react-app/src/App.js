import React, { useEffect, useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import CourseBoard from './course_board';
import CourseMaterials from './course_meterials';
import WriteMaterials from './write_materials';
import CourseQuestion from './course_question';
import WriteQuestion from './write_question';
import CourseNotice_Main from './Course_Notice/CourseNotice_Main';

const App = () => {
	return (
		<BrowserRouter>
			<Routes>
				<Route path="/CourseBoard" element={<CourseBoard />} />
				<Route path="/CourseMaterials" element={<CourseMaterials />} />
				<Route path="/WriteMaterials" element={<WriteMaterials />} />
				<Route path="/CourseQuestion" element={<CourseQuestion />} />
				<Route path="/WriteQuestion" element={<WriteQuestion />} />
				<Route path="/CourseNotice" element={<CourseNotice_Main />} />
			</Routes>
		</BrowserRouter>
	);
};

export default App;