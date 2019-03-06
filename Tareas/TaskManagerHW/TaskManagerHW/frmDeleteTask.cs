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
    public partial class frmEndTask : Form
    {
        private ProcessManager ProcessManager = new ProcessManager();

        public frmEndTask()
        {
            InitializeComponent();
        }

        private void btnTerminar_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(txtProcessId.Text))
            {
                try
                {
                    Process.GetProcessById(Int32.Parse(txtProcessId.Text.ToString())).Kill();
                }
                catch (Exception ex)
                {
                    MessageBox.Show(ex.Message, "Message", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
        }

        private void frmEndTask_Load(object sender, EventArgs e)
        {            
        }
    }
}
