import Board from "../views/Board";
import Task from "../views/Task";

export default [
  {
    path: "/",
    name: "board",
    component: Board,
    children: [
      {
        path: "task/:id",
        name: "task",
        component: Task
      }
    ]
  }
];
