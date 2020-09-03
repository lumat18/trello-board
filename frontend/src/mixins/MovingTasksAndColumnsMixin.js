export default {
  props: {
    column: {
      type: Object,
      required: true
    },
    columnIndex: {
      type: Number,
      required: true
    },
    board: {
      type: Object,
      required: true
    }
  },
  methods: {
    moveTaskOrColumn(transferData) {
      if (transferData.type === "task") {
        this.moveTask(transferData);
      } else {
        this.moveColumn(transferData);
      }
    },
    moveTask({ fromColumnIndex, fromTaskIndex }) {
      const fromColumnTasks = this.board.columns[fromColumnIndex].tasks;

      this.$store.commit("MOVE_TASK", {
        fromColumnTasks,
        toColumnTasks: this.column.tasks,
        taskIndex: fromTaskIndex,
        toTaskIndex: this.taskIndex
      });
    },
    moveColumn({ fromColumnIndex }) {
      this.$store.commit("MOVE_COLUMN", {
        fromColumnIndex,
        toColumnIndex: this.columnIndex
      });
    }
  }
};
