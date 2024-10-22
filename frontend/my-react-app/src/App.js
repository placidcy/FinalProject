import React, { useEffect, useState } from 'react';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import CourseBoard from './course_board';
import CourseMaterials from './course_meterials';
import WriteMaterials from './write_materials';

const App = () => {
	return (
		<BrowserRouter>
			<Routes>
				<Route path="/CourseBoard" element={<CourseBoard />} />
				<Route path="/CourseMaterials" element={<CourseMaterials />} />
				<Route path="/WriteMaterials" element={<WriteMaterials />} />
			</Routes>
		</BrowserRouter>
	);
};

export default App;