using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Diagnostics;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TaskManagerHW
{
    public partial class frmRunTask : Form
    {
        private ProcessManager ProcessManager = new ProcessManager();

        public object Processes { get; private set; }

        public frmRunTask()
        {
            InitializeComponent();
        }

        private void runTask_Load(object sender, EventArgs e)
        {

        }

        private void btnRun_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(txtProcessName.Text))
            {
                try
                {                    
                    Process.Start(txtProcessName.Text);

                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }
    }
}
