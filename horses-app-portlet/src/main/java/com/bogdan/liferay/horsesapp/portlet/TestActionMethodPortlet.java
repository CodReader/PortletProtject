package com.bogdan.liferay.horsesapp.portlet;

import com.bogdan.liferay.horsesapp.constants.HorsesAppPortletKeys;
import com.bogdan.lifray.serviceapp.api.Constants;
import com.bogdan.lifray.serviceapp.api.Horse;
import com.bogdan.lifray.serviceapp.api.HorseGenerator;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import org.osgi.service.component.annotations.Component;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author bogdan
 */
@Component(
        immediate = true,
        property = {
                "com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=true",
                "javax.portlet.display-name=HorsesAppPortlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/view.jsp",
                "javax.portlet.name=" + HorsesAppPortletKeys.horsesAppPortlet,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class TestActionMethodPortlet extends MVCPortlet {

    private static final Horse horse = new Horse(HorseGenerator.randomSpeed());
    private static final Logger logger = Logger.getLogger(TestActionMethodPortlet.class.getName());

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

        renderRequest.setAttribute("bet", renderRequest.getParameter("bet"));

        renderRequest.setAttribute("horse", renderRequest.getParameter("horse"));


        super.render(renderRequest, renderResponse);
    }

    @ProcessAction(name = "actionMethod1")
    public void sampleActionMethod(ActionRequest request, ActionResponse response)
            throws SystemException {
        List<Horse> horses = HorseGenerator.generateHorses(Constants.HORS_SIZE);
        request.setAttribute("horses", horses);
    }
}
