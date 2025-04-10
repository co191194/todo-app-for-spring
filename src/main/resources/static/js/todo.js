/**
 * 画面初期表示時の処理
 */
window.addEventListener("load", () => {
	// 更新ボタンの要素を取得
	const updateButtons = document.querySelectorAll("[name='updateBtn']");
	// 更新ボタンのイベントリスナーを追加
	updateButtons.forEach((button) => {
		button.addEventListener("click", (event) => {
			const todoId = event.currentTarget.dataset.todoId;
			const todoDate = document.querySelector(`[name='todoDate${todoId}']`).value;
			const todoTitle = document.querySelector(`[name='todoTitle${todoId}']`).value;
			const todoContent = document.querySelector(`[name='todoContent${todoId}']`).value;
			const todoVersion = document.querySelector(`[name='todoVersion${todoId}']`).value;

			fetch(`/todo/update`, {
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify({
					todoId: todoId,
					todoDate: todoDate,
					todoTitle: todoTitle,
					todoContent: todoContent,
					version: todoVersion,
				}),
			})
				.then((response) => {
					if (response.ok) {
						location.reload();
					} else {
						alert("Failed to update Todo.");
					}
				})
				.catch((error) => {
					console.error("Error:", error);
					alert("An error occurred while updating Todo.");
				});
		});
	});
	// 削除ボタンの要素を取得
	const deleteButtons = document.querySelectorAll("[name='deleteBtn']");
	// 削除ボタンのイベントリスナーを追加
	deleteButtons.forEach((button) => {
        button.addEventListener("click", (event) => {
            const todoId = event.currentTarget.dataset.todoId;
            fetch(`/todo/delete/${todoId}`, {
                method: "GET",
            })
                .then((response) => {
                    if (response.ok) {
                        location.reload();
                    } else {
                        alert("Failed to delete Todo.");
                    }
                })
                .catch((error) => {
                    console.error("Error:", error);
                    alert("An error occurred while deleting Todo.");
                });
        });
    });

})