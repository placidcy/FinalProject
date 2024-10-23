function saveNoteHandler() {
    const saveNoteBtn = document.querySelector('#saveNoteBtn');
    const textarea = document.querySelector('.textarea');

    saveNoteBtn.addEventListener('click', function() {
        const noteContent = textarea.value.trim();

        if (!noteContent) {
            alert('내용을 입력해주세요.');
            return;
        }

        const now = new Date();
        const year = now.getFullYear();
        const month = ('0' + (now.getMonth() + 1)).slice(-2);
        const day = ('0' + now.getDate()).slice(-2); 
        const hours = ('0' + now.getHours()).slice(-2); 
        const minutes = ('0' + now.getMinutes()).slice(-2); 

        const noteDate = year + '-' + month + '-' + day + ' ' + hours + ':' + minutes;

        const note = {
            date: noteDate,
            content: noteContent
        };

        const notes = JSON.parse(localStorage.getItem('notes')) || [];
        notes.push(note);
        window.localStorage.setItem('notes', JSON.stringify(notes));

        textarea.value = '';

        // 노트가 추가되면 '노트가 없습니다' 메시지 제거
        const emptyMessage = document.querySelector('#emptyMessage');
        if (emptyMessage) {
            emptyMessage.remove();
        }

        addNoteToList(noteDate, noteContent, notes.length - 1);
    });
}

function addNoteToList(date, content, index) {
    const noteListBox = document.querySelector('#noteListBox');

    let noteBox = document.createElement('div');
    noteBox.setAttribute('id', 'noteBox');

    let noteDate = document.createElement('div');
    noteDate.classList.add('noteDate');
    noteDate.textContent = '작성일 ' + date + ' ';

    let noteContent = document.createElement('div');
    noteContent.classList.add('noteContent');
    noteContent.textContent = content;

    let deleteBtn = document.createElement('button');
    deleteBtn.setAttribute('id', 'deleteBtn');
    deleteBtn.innerHTML = '삭제';

    deleteBtn.addEventListener('click', function() {
        deleteNoteFromLocalStorage(index);
        noteBox.remove();

        // 노트가 모두 삭제되면 '노트가 없습니다' 메시지 표시
        if (document.querySelectorAll('#noteBox').length === 0) {
            showEmptyMessage();
        }
    });

    noteDate.appendChild(deleteBtn);
    
    noteBox.appendChild(noteDate);
    noteBox.appendChild(noteContent);

    noteListBox.prepend(noteBox);
}

// 로컬 스토리지에서 메모 삭제 함수
function deleteNoteFromLocalStorage(index) {
    const notes = JSON.parse(localStorage.getItem('notes')) || [];
    notes.splice(index, 1);
    window.localStorage.setItem('notes', JSON.stringify(notes));
}

// 로컬 스토리지에 저장된 노트가 없을 때 메시지 표시 함수
function showEmptyMessage() {
    const noteListBox = document.querySelector('#noteListBox');
    const emptyMessage = document.createElement('h3');
    emptyMessage.setAttribute('id', 'emptyMessage');
    emptyMessage.textContent = '현재 등록된 노트 필기가 없습니다.';
    noteListBox.appendChild(emptyMessage);
}

// 로컬 스토리지에서 메모 불러오기 및 처리
function loadNotes() {
    const notes = JSON.parse(localStorage.getItem('notes')) || [];

    if (notes.length === 0) {
        showEmptyMessage(); // 노트가 없으면 메시지 표시
    } else {
        notes.forEach((note, index) => {
            addNoteToList(note.date, note.content, index);
        });
    }
}

function dialog() {
    const memoBtn = document.querySelector('#memoBtn');
    const exit = document.querySelector('.exit');
    const dialog = document.querySelector('dialog');

    memoBtn.addEventListener('click', () => {
        dialog.showModal();
    });
    exit.addEventListener('click', () => {
        dialog.close();
    });
}

function initNote() {
    dialog();
    loadNotes();
    saveNoteHandler();
}

window.addEventListener('load', initNote);
