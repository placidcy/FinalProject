import React, { useEffect, useState } from 'react';
import { useLocation, useNavigate } from 'react-router-dom';
import Sidebar from './side_course';
import './css/course_board.css';
import './css/course_mu.css';

const CourseBoard = () => {
    const location = useLocation();
    const navigate = useNavigate();
    const [courseId, setCourseId] = useState(null);
    const [posts, setPosts] = useState([]);
    const [baseURL, setBaseURL] = useState('');
    const [userId, setUserId] = useState(null);
    const [userRole, setUserRole] = useState(null);

    useEffect(() => {
        const { protocol, host } = window.location;
        setBaseURL(`${protocol}//${host.split(':')[0]}:8080`);
    }, []);

    useEffect(() => {
        const queryParams = new URLSearchParams(location.search);
        const id = queryParams.get('courseId');
        const user = queryParams.get('userId');
        const role = queryParams.get('role');

        if (id && baseURL) {
            setCourseId(id);
            if (user) {
                sessionStorage.setItem('userId', user);
                if (role) {
                    sessionStorage.setItem('userRole', role);
                }
                navigate(`/CourseBoard?courseId=${id}`);
            } else {
                const storedUserId = sessionStorage.getItem('userId');
                const storedUserRole = sessionStorage.getItem('userRole');
                setUserId(storedUserId);
                setUserRole(storedUserRole);
            }
            fetchPosts(id);
        }
    }, [location, baseURL, navigate]);

    const fetchPosts = async (id) => {
        const apiUrl = `${baseURL}/api/coursesBoard/${id}`;

        try {
            const response = await fetch(apiUrl, {
                headers: {
                    Accept: "application/json",
                },
                method: "GET",
            });

            if (!response.ok) {
                throw new Error(`response 오류 / status: ${response.status}`);
            }

            const data = await response.json();
            setPosts(data);
        } catch (error) {
            console.error('Fetch error:', error);
        }
    };

    const notices = posts.filter(post => post.typeId === 1);
    const materials = posts.filter(post => post.typeId === 2);
    const questions = posts.filter(post => post.typeId === 3);

    return (
        <>
            <Sidebar courseId={courseId} />

            <main>
                <div className="header">
                    <a href={`/CourseBoard?courseId=${courseId}`} className="button active">전체 목록</a>
                    <a href={`/notices?courseId=${courseId}`} className="button">공지 사항</a>
                    <a href={`/CourseMaterials?courseId=${courseId}`} className="button">강의 자료</a>
                    <a href={`/questions?courseId=${courseId}`} className="button">질문</a>
                </div>
				
                <div className="course-board-list">
                    <div className="course-notice">
                        <span className="board-title">공지 사항</span>
                        <div className="item">
                            {notices.length > 0 ? (
                                notices.map(notice => (
                                    <a href="#" className="post" key={notice.postId}>
                                        <span className="title">{notice.title}</span>
                                        <span className="date">게시일: {notice.regDate}</span>
                                    </a>
                                ))
                            ) : (
                                <span>작성된 공지 사항이 없습니다.</span>
                            )}
                        </div>
                    </div>

                    <div className="course-materials">
                        <span className="board-title">강의 자료</span>
                        <div className="item">
                            {materials.length > 0 ? (
                                materials.map((material) => (
                                    <div key={material.postId}>
                                        <a href="#" className="title">{material.title}</a>
                                        <div className="file-list">
                                            <div className="file-info">
                                                <span className="file">첨부된 파일</span>
                                                <div className="files">
                                                    {material.attachments && material.attachments.map((file, index) => (
                                                        <a key={index} href="#">{file}</a>
                                                    ))}
                                                    {material.attachments.length === 0 && (
                                                        <span>업로드된 자료가 없습니다.</span>
                                                    )}
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                ))
                            ) : (
                                <span>업로드된 자료가 없습니다.</span>
                            )}
                        </div>
                    </div>

                    <div className="course-question">
                        <span className="board-title">질문</span>
                        <div className="item">
                            {questions.length > 0 ? (
                                questions.map(question => (
                                    <a href="#" className="post" key={question.postId}>
                                        <span className="title">{question.title}</span>
                                        <span className="date">게시일: {question.regDate}</span>
                                    </a>
                                ))
                            ) : (
                                <span>작성된 질문 게시글이 없습니다.</span>
                            )}
                        </div>
                    </div>
                </div>
            </main>
        </>
    );
};

export default CourseBoard;
