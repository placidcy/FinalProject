import React, { useEffect, useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import CourseBoard from './course_board';
import CourseMaterials from './course_meterials';
import WriteMaterials from './write_materials';
import CourseNotice from './Course_Notice/CourseNotice_Main';
const App = () => {
	return (
		<BrowserRouter>
			<Routes>
				<Route path="/CourseBoard" element={<CourseBoard />} />
				<Route path="/CourseMaterials" element={<CourseMaterials />} />
				<Route path="/WriteMaterials" element={<WriteMaterials />} />
				<Route path="/notices" element={<CourseNotice />} />
			</Routes>
		</BrowserRouter>
	);
};

export default App;