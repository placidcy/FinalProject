import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import CourseBoard from './course_board';
import CourseMaterials from './course_meterials';
import WriteMaterials from './write_materials';

const App = () => {
	return (
		<Routes>
			<Route path="/CourseBoard" element={<CourseBoard />} />
			<Route path="/CourseMaterials" element={<CourseMaterials />} />
			<Route path="/WriteMaterials" element={<WriteMaterials />} />
		</Routes>
	);
};

export default App;
